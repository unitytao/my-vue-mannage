/*
直接更新state的多个方法的对象
 */
import Vue from 'vue'
import {
  RECEIVE_USER_INFO,
  RECEIVE_COURSE_INFO,
  RECEIVE_COURSE_DATA,
  RECEIVE_CLASS_GOAL,
  RECEIVE_CLASS_URL,
  RECEIVE_CLASS_Main,
  RECEIVE_CLASS_More,
  RECORD_ALL_CLASS,
  CLEAN_CLASS,
  SPLICE_COURSE_CONTENT,
  RECEIVE_FILE_INFO,
  RECEIVE_NOW_CLASS,
  RECEIVE_NOW_DATA,
  RECEIVE_COURSE_BY_URL_DATA
} from './mutation-types'

export default {
  [RECEIVE_USER_INFO](state, {userInfo}) {
    state.userInfo = userInfo
  }
}
