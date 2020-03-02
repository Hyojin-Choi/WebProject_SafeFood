<template>
<div>

 <div class="container">
    <div class="main col-md-12">
    <div class="hovereffect col-xs-6 col-lg-3" v-for="food in info" :key="food.code">
      <h2 v-html="food.name"></h2>
	<img :src=getImgUrl(food.image) style="width:240px"
		class="img-responsive" alt="">
    <div class="overlay" ><h2 v-html="food.name"></h2>
    <button class= "info btn-light" @click="show_detail(food.code)">상품정보보기</button>
    </div>
    </div>
    </div>
	</div>
	<footer class="footer">
		<div class="container"></div>
	</footer>

  </div>
</template>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "MainList",
  data () {
        return {
		loading: true,
		errored: false ,
		info:[]
        }//return
  },
  components: {
	},
  computed: {
	},
  methods: {
	getImgUrl(pic) {
    return require('../assets/'+pic)
  },
  show_detail: function(code) {
      alert(code + "상세보기");
      this.$router.push("/fooddetail/" + code);
	}
  },
  mounted () {
    http
      .get('/productInfo')
      .then(response => (this.info = response.data))
      .catch(() => {
        this.errored = true
      })
      .finally(() => this.loading = false);
  }
};
</script>