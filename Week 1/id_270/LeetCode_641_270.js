class MyCircularDeque {
  constructor(len) {
    this.len = len
    this._store = []
  }
  insertFront(value) {
    if (this.isFull()) {
      return false
    }
    this._store.unshift(value)
    return true
  }

  insertLast(value) {
    if (this.isFull()) {
      return false
    }
    this._store.push(value)
    return true
  }

  deleteFront() {
    if (this.isEmpty()) {
      return false
    }
    this._store.shift()
    return true
  }
  deleteLast() {
    if (this.isEmpty()) {
      return false
    }
    this._store.pop()
    return true
  }
  getFront() {
    if (this.isEmpty()) {
      return -1
    }
    return this._store[0]

  }
  getRear() {
    if (this.isEmpty()) {
      return -1
    }
    return this._store[this._store.length - 1]
  }
  isEmpty() {
    return this._store.length === 0
  }
  isFull() {
    return this._store.length === this.len
  }
}
