 /*
包含n个接口请求函数的模块
函数的返回值: promise对象
 */
import ajax from './ajax'
/*const BASE_URL = 'http://localhost:8090'*/
 const BASE_URL= '/api'

//密码登录验证
export const reqPwdLogin =({account, password}) => ajax(BASE_URL+'/user/check',{account,password})
 //注册
export const reqPwdRegister =({account, password}) => ajax(BASE_URL+'/user/register',{account,password})
 //名字查询部门
 export const reqSelectByName =({bmName}) => ajax(BASE_URL+'/depart/findByName',{bmName})
 //查询所有部门
 export const reqFindAll=() => ajax(BASE_URL+'/depart/findAll')
 //id查询部门
 export const reqSelectById=(id) => ajax(BASE_URL+'/depart/findById',id)
 //修改部门
 export const reqUpdateDepartment=(date) => ajax(BASE_URL+'/depart/update',date)
 //修改岗位
 export const reqUpdatePosition=({id,gwName,depId}) => ajax(BASE_URL+'/position/update',{id,gwName,depId})
 //修改人员岗位
 export const reqUpdatePersonPosition=({userId,depId,ptnId}) => ajax(BASE_URL+'/position/update',{userId,depId,ptnId})
 //添加部门
 export const reqAddDepart =({bmName, superiorId}) => ajax(BASE_URL+'/depart/add',{bmName,superiorId})
 //id删除部门
 export const reqDelById=({id}) => ajax(BASE_URL+'/depart/delete',{id})
 //添加岗位
 export const reqAddPosition=({gwName, dplId}) => ajax(BASE_URL+'/position/add',{gwName,dplId})
 //查询所有员工
 export const reqFindAllPerson=() => ajax(BASE_URL+'/user/findAll')
 //查询所有职位
 export const reqFindAllWork=() => ajax(BASE_URL+'/position/findAll')
 //id查询员工
 export const reqFindAPersonById=({id}) => ajax(BASE_URL+'/user/findById',{id})
 //姓名查询员工
 export const reqFindPersonByName=({name}) => ajax(BASE_URL+'/user/findByName',{name})
 //id删除部门
 export const reqDelGWById=({id}) => ajax(BASE_URL+'/position/delete',{id})
 //转正
 export const reqSetTestOver=({id}) => ajax(BASE_URL+'/user/setTestOver',{id})
 //离职
 export const reqSetFired=({id}) => ajax(BASE_URL+'/user/setFired',{id})
 //添加员工
 export const reqAddUser=({name,gender,birthday,idCard,depId,psnId}) => ajax(BASE_URL+'/user/add',{name,gender,birthday,idCard,depId,psnId})
 export const reqSelectByNameJob =({name}) => ajax(BASE_URL+'/position/findByName',{name})
 export const reqSelectByIdJob =({id}) => ajax(BASE_URL+'/position/findById',{id})


