<template>
  <div>
    <mu-circular-progress :size="40" v-if="loading"/>
    <div v-html="html"></div>
  </div>
</template>

<script>
    export default {
      name: "HtmlPanel",
      // 使用时请使用 :url.sync=""传值
      props:{
        url:{
          type:String,
          required: true
        }
      },
      data(){
        return{
          loading:false,
          html:''
        }
      },
      watch:{

      },
      mounted() {

      },
      methods:{
          load(url){
            if (url && url.length > 0){
              //加载中
              this.loading = true
              let param ={
                accept: 'text/html, text/plain'
              }
              this.$http.get(url,parm).then((response) => {
                this.loading = false
                // 处理HTML显示
                this.html = response.data
              }).catch(
                this.loading = false
                this.html = '加载失败,请确认网络状态'
              )
            }
          }
      }
    }
</script>

<style scoped>

</style>
