/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import Vue from 'vue'
import NotificationVue from './notification.vue'
import { PopupManager } from '../../utils/popup'
import { isVNode } from '../../utils/assist'
const NotificationConstructor = Vue.extend(NotificationVue)

let instance
let instances = []
let seed = 1

const Notification = function (options) {
  if (Vue.prototype.$isServer) return
  options = options || {}
  const userOnClose = options.onClose
  const id = 'notification_' + seed++
  const position = options.position || 'top-right'

  options.onClose = function () {
    Notification.close(id, userOnClose)
  }

  instance = new NotificationConstructor({
    data: options
  })

  if (isVNode(options.message)) {
    instance.$slots.default = [options.message]
    options.message = 'REPLACED_BY_VNODE'
  }
  instance.id = id
  instance.$mount()
  document.body.appendChild(instance.$el)
  instance.visible = true
  instance.dom = instance.$el
  instance.dom.style.zIndex = PopupManager.nextZIndex()
  let verticalOffset = options.offset || 0
  instances.filter(item => item.position === position).forEach(item => {
    verticalOffset += item.$el.offsetHeight + 16
  })
  verticalOffset += 16
  instance.verticalOffset = verticalOffset
  // instance.dom.style.top = verticalOffset + 'px';
  instances.push(instance)
  return instance
};

['success', 'warning', 'info', 'error'].forEach(type => {
  Notification[type] = options => {
    if (typeof options === 'string' || isVNode(options)) {
      options = {
        message: options
      }
    }
    options.type = type
    return Notification(options)
  }
})

Notification.close = function (id, userOnClose) {
  let index = -1
  const len = instances.length
  const instance = instances.filter((instance, i) => {
    if (instance.id === id) {
      index = i
      return true
    }
    return false
  })[0]
  if (!instance) return

  if (typeof userOnClose === 'function') {
    userOnClose(instance)
  }
  instances.splice(index, 1)

  if (len <= 1) return
  const position = instance.position
  const removedHeight = instance.dom.offsetHeight
  for (let i = index; i < len - 1; i++) {
    if (instances[i].position === position) {
      instances[i].dom.style[instance.verticalProperty] =
        parseInt(instances[i].dom.style[instance.verticalProperty], 10) - removedHeight - 16 + 'px'
    }
  }
}

Notification.closeAll = function () {
  for (let i = instances.length - 1; i >= 0; i--) {
    instances[i].close()
  }
}

export default Notification
