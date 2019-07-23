<template>
  <div class="home-container">
    <vHeader></vHeader>
    <vSideBar></vSideBar>
    <div class="content-box" :class="{'content-collapse':collapse}">
      <vTags></vTags>
      <div class="content">
        <transition name="move" mode="out-in">
          <keep-alive :include="tagsList">
            <router-view></router-view>
          </keep-alive>
        </transition>
      </div>
    </div>
  </div>
</template>

<script>
  import vHeader from "@/components/Header.vue"
  import vSideBar from '@/components/SideBar.vue';
  import vTags from '@/components/Tags.vue';
  import { EventBus } from '../assets/js/bus';
  export default {
    name: "Home",
    components:{
      vHeader,vSideBar,vTags,
    },
    data(){
      return {
        tagsList: [],
        collapse: false
      }
    },
    created() {
      EventBus.$on('collapse', msg => {
        this.collapse = msg;
      })
    },
  }
</script>

<style scoped>

</style>
