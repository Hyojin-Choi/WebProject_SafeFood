<template>
<div id="BoardDetail">
    <div class="list-util-wrap">
		<div class="list-util position-base type-scroll">
			<div class="list-filter-wrap wrap-unit">

				<div class="bar"
					style="transform: translate3d(0px, 0px, 0px); width: 102px;"></div>
			</div>
		</div>
	</div>

	<div class="panel panel-default">
		<div class="panel-body">
			<!-- <form class="form-horizontal" action="#" id="rform" name="board" method="post"> -->
				<table class="table text-center table-bordered table-hover">
					<thead>
						<tr v-for="bo in bboard" :key="bo.num">
							<th scope="col" class="id">작성자</th>
							<th scope="col" class="id" v-html="bo.name"></th>
							<th scope="col" class="title">제목</th>
							<th scope="col" class="title" v-html="bo.title"></th>
							<th scope="col" class="date">등록일</th>
							<th scope="col" class="date" v-html="bo.date"></th>
							<!--<th scope="col" class="viewcnt">조회수</th>
							<th scope="col" class="viewcnt" v-html="bo.cnt"></th>-->
						</tr>
						<!-- <tr>
							<th scope="col" class="link" colspan="10" v-html="bboard.content"><span></span></th>
						</tr> -->
					</thead>

				</table>
					<div class="col-sm-12 text-right">
						<button type="button" @click="boardupdate(bboard.num)">수정</button>
						<button type="button" @click="boarddelete(bboard.num)">삭제</button>
					</div>
			<!-- </form> -->

		</div>
	</div>
</div>
</template>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "Board",
  props: ["num"],
  data () {
        return {
		loading: true,
		errored: false ,
		info:[],
		bboard: {}
        }//return
  },
  components: {
	},
  computed: {
	},
  methods: {
	// boardupdate(num){
	// 	http
	// 	.update('/boardupdate/'+num)
	// 	.then(response => {
	// 		if (response.data=="게시물 수정 성공") {
	// 			alert("수정 성공");
	// 			this.$router.push("/board");
	// 		}else{
	// 			alert("수정 실패");
	// 		}
	// 	})
	// 	.catch(() => {
    //       this.errored = true;
    //     })
    //     .finally(() => (this.loading = false));
	// 	this.submitted = true;
	// },
	boardupdate(num){
		this.$router.push("/boardupdate/" + num);
	},
	boarddelete (num){
		this.$router.push("/boarddelete/" + num);
	}
  },
  mounted () {
	http
	.get('/boardselectall')
	.then(response => {
		alert("Qweqwe");
		this.bboard = response.data;
		})
		.catch(() => {
			this.errored = true
      })
      .finally(() => this.loading = false);
  }
};
</script>
