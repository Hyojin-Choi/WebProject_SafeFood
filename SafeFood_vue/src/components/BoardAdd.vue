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

		<div class="panel panel-default">
			<div class="panel-body">

				<div class="main hc-element-invisi	ble"
					data-animation-effect="fadeInUpSmall" data-effect-delay="100">
					<div class="form-block p-30 light-gray-bg border-clear"
						style="width: 100%">
						<h2 class="title">게시글 작성</h2>

						<form class="form-horizontal" action="boardreg" id="rform"
							method="post" @submit.prevent="boardreg">

							<div class="form-group has-feedback row">
								<label for="bname"
									class="col-md-3 control-label text-md-right col-form-label">작성자
									<span class="text-danger small">*</span>
								</label>
								<div class="col-md-8">
									<input type="text" class="form-control" id="bname" required name="bname"
										placeholder="작성자를 입력하세요." v-model="bname"> <i
										class="fa fa-pencil form-control-feedback pr-4"></i>
								</div>
							</div>
							<div class="form-group has-feedback row">
								<label for="btitle"
									class="col-md-3 control-label text-md-right col-form-label">제목
									<span class="text-danger small">*</span>
								</label>
								<div class="col-md-8">
									<input type="text" class="form-control" id="btitle" required name="btitle"
										placeholder="제목을 입력하세요." v-model="btitle"> <i
										class="fa fa-pencil form-control-feedback pr-4"></i>
								</div>
							</div>
							<div class="form-group has-feedback row">
								<label for="bmemo"
									class="col-md-3 control-label text-md-right col-form-label">내용
									<span class="text-danger small">*</span>
								</label>
								<div class="col-md-8">
									<textarea class="form-control" id="bmemo"
										placeholder="내용을 입력하세요. " required name="bmemo"
										v-model="bmemo"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 text-right">
									<button type="submit">저장</button>
								</div>
								<div class="col-sm-12 text-right">
									<button type="reset">취소</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
  name: "BoardAdd",
  data () {
        return {
		loading: true,
		errored: false ,
		info:[],
		//cboard: {},
		bnum:"",
		bname:"",
		bmemo:"",
		bid:"ssafy",
		btitle: "",
		bdate: "",
        bcnt:"",
        }//return
  },
  components: {
	},
  computed: {
	},
  methods: {
      boardreg() {
		if(this.cname==''){ alert('이름을 입력하세요.'); return ;}
		if(this.ctitle==''){ alert('제목을 입력하세요.'); return ;}
		if(this.cmemo==''){ alert('내용을 입력하세요.'); return ;}
		
		http
		.post('/boardinsert', {
			num : this.bnum,
			name: this.bname,
			title: this.btitle,
			memo: this.bmemo,
			date: this.bdate,
			cnt:this.bnt
		})
		.then(response => {
			if (response.data=="게시물 작성 성공") {
				alert("등록 성공");
				this.$router.push("/board");
			}else{
				alert("등록 실패");
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
  }
};
</script>