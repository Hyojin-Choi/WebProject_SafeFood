<template>
<div class="content">
		<div class="list-util-wrap">
			<div class="list-util position-base type-scroll">
				<div class="list-filter-wrap wrap-unit">

					<div class="bar"
						style="transform: translate3d(0px, 0px, 0px); width: 102px;"></div>
				</div>
			</div>
		</div>
		<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="board">공지사항</a></li>
					<li><a href="boardQnA">Q & A </a></li>
				</ul>
				<form action="searchname" method="post" class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" name="name" class="form-control" placeholder="Search">
					</div>	
					<button type="submit" class="btn btn-default">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">인기검색어
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu" style="background-color : white " id="wordlist">
						</ul></li>
				</ul>

			</div>

		<div class="panel panel-default">
			<div class="panel-body">
				<table class="table text-center table-bordered table-hover">
					<caption class="blind">공지사항 공지 목록</caption>
					<thead>
						<tr>
							<th scope="col" class="num type2 hidden-field"><span>번호</span></th>
							<th scope="col" class="name type2 hidden-field"><span>작성자</span></th>
							<th scope="col" class="title"><span>제목</span></th>
							<th scope="col" class="date"><span>등록일</span></th>
							<!--<th scope="col" class="cnt"><span>조회수</span></th>-->
						</tr>
					</thead>
					<tbody>
						<tr v-for="board in info" :key="board.id">
                            <th v-html="board.num " @click="show_detail(board.num)"></th>
							<th v-html="board.name"></th>
							<th v-html="board.title" @click="show_detail(board.num)"></th>
							<th v-html="board.date"></th>
							<button @click="del(board.num)">삭제</button>
						</tr>
					</tbody>
				</table>
				<div class="col-sm-12 text-right">
						<router-link class="btn btn-primary" to="/boardinsert">글쓰기</router-link>
					</div>
	
			</div>
		</div>
	</div>
</template>

<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "Board",
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
	show_detail: function(boardnum) {
		alert(boardnum + "상세보기");
		this.$router.push("/boardupdate/" + boardnum);
	},
	del:function(bdid){
		alert(bdid + "번 삭제");
		http
		.delete('/boarddelete/'+bdid)
		.then(response => {
			if (response.data=="게시물 삭제 성공") {
				alert("삭제 성공");
				this.$router.push("/board");
			}else{
				alert("삭제 실패");
			}
		})
		.catch(() => {
          this.errored = true;
        })
        .finally(() => (this.loading = false));
		this.submitted = true;
	}
  },

  mounted () {
    http
      .get('/boardselectall')
      .then(response => (this.info = response.data))
      .catch(() => {
        this.errored = true
      })
      .finally(() => this.loading = false);
  }
};
</script>