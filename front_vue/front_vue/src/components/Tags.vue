<template>
  <div class="tags" >
    <ul>
      <li v-for="(item,index) in tagsList">

      </li>
      <div class="tags-close-box">
        <el-dropdown @command="handleCommand">
          <el-button size="mini" type="primary">
            标签操作<i class="el-icon-arrow-down el-icon--right"></i>
          </el-button>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="other">关闭其他</el-dropdown-item>
            <el-dropdown-item command="all">关闭所有</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </ul>
  </div>
</template>

<script>
  import { EventBus } from '../assets/js/bus';
  export default {
    name: "Tags",
    data() {
      return {
        tagsList: []
      }
    },
    methods: {

    },
  }
</script>

<style scoped>
  .tags {
    position: relative;
    height: 30px;
    overflow: hidden;
    background: #fff;
    padding-right: 120px;
    box-shadow: 0 5px 10px #ddd;
  }

  .tags ul {
    box-sizing: border-box;
    width: 100%;
    height: 100%;
  }
  .tags-close-box {
    position: absolute;
    right: 0;
    top: 0;
    box-sizing: border-box;
    padding-top: 1px;
    text-align: center;
    width: 110px;
    height: 30px;
    background: #fff;
    box-shadow: -3px 0 15px 3px rgba(0, 0, 0, .1);
    z-index: 10;
  }
</style>
