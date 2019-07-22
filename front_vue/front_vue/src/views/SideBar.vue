<template>
  <div class="home-sidebar">
    <el-menu class="sidebar-el-menu" :collapse="collapse" background-color="#324157"
             text-color="#bfcbd9" active-text-color="#20a0ff" unique-opened router>
      <template v-for="item in items">
        <template v-if="item.subs">
        </template>
        <template v-else>
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i><span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
  import { EventBus } from '../assets/js/bus';
  export default {
    name: "SideBar",
    data() {
      return {
        collapse:false,
        items: [
          {
            icon: 'el-icon-house',
            index: 'dashboard',
            title: '系统首页'
          },
          {
            icon: 'el-icon-tickets',
            index: 'table',
            title: '基础表格'
          },
      ]
      }
    },
    created(){
      // 通过 Event Bus 进行组件间通信，来折叠侧边栏
      EventBus.$on('collapse', msg => {
        this.collapse = msg;
      })
    },
  }
</script>

<style scoped>
  .home-sidebar{
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom:0;
    overflow-y: scroll;
  }
  .home-sidebar::-webkit-scrollbar{
    width: 0;
  }
  .sidebar-el-menu:not(.el-menu--collapse){
    width: 250px;
  }
  .home-sidebar > ul {
    height:100%;
  }
</style>
