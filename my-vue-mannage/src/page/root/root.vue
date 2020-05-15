<template>
    <div>
      <el-container>
        <el-aside width="200px">
          <el-row class="tac">
            <el-col :span="24">
              <el-menu
                default-active="2"
                class="el-menu-vertical-demo"
                >
                <el-menu-item index="1">
                  <i class="el-icon-menu"></i>
                  <span slot="title">首页</span>
                </el-menu-item>
                <el-submenu index="2">
                  <template slot="title">
                    <i class="el-icon-location"></i>
                    <span>部门管理</span>
                  </template>
                  <el-menu-item-group>
                    <el-menu-item index="2-1"><router-link to="/root/add_department">添加部门</router-link></el-menu-item>
                    <el-menu-item index="2-2"><router-link to="/root/del_department">部门查询</router-link></el-menu-item>
                  </el-menu-item-group>
                </el-submenu>
                <el-submenu index="3">
                  <template slot="title">
                    <i class="el-icon-menu"></i>
                    <span>岗位管理</span>
                  </template>
                  <template>
                    <el-menu-item-group>
                      <el-menu-item index="3-1"><router-link to="/root/add_station">添加岗位</router-link></el-menu-item>
                      <el-menu-item index="3-2"><router-link to="/root/del_station">岗位查询</router-link></el-menu-item>
                    </el-menu-item-group>
                  </template>
                </el-submenu>
                <el-submenu index="4">
                  <template slot="title">
                    <i class="el-icon-document"></i>
                    <span>员工中心</span>
                  </template>
                  <template>
                    <el-menu-item-group>
                      <el-menu-item index="4-1"><router-link to="/root/add_personnel">添加员工</router-link></el-menu-item>
                      <el-menu-item index="4-2"><router-link to="/root/del_personnel">员工信息查询</router-link></el-menu-item>
                      <el-menu-item index="4-3"><router-link to="/root/work">职位管理</router-link></el-menu-item>
                    </el-menu-item-group>
                  </template>
                </el-submenu>
                <el-menu-item index="5">
                  <i class="el-icon-setting"></i>
                  <span slot="title">更多</span>
                </el-menu-item>
              </el-menu>
            </el-col>
          </el-row>
        </el-aside>
        <el-main><router-view></router-view></el-main>
      </el-container>
    </div>
</template>

<script>
  export default {
    name: 'root'
  }
</script>

<style scoped>
 a{
    color: #333333;
   text-decoration-line: none;
 }
</style>
