<template>
<div class="container">
    <div class="form-group">
        <label for="email">ID*:</label> <br /> 
        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" v-model="pid">
    </div>
    <div class="form-group">
        <label for="pwd">Password*:</label><br /> 
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" v-model="ppw1">
    </div>
    <div class="form-group">
        <label for="userPwCheck">비밀번호 확인*</label><br /> 
        <input type="password" id="userPwCheck" class="form-control" maxlength="20" autocomplete="off"> 
	</div>
    <div class="form-group">
        <label for="username">이름*</label><br />
        <input type="text" id="userId" class="form-control" maxlength="20" value="" v-model="pname">
	</div>
	<div class="form-group">
		<label for="useradress">주소*</label><br /> 
        <input type="text" id="userId" class="form-control" maxlength="20" value="" v-model="paddr">
	</div>
	<div class="form-group">
		<label for="email01">이메일*</label>
	</div>
    <div class="form-group">
        <input type="text" id="email01" class="form-inline" name="email01" size="20" maxlength="20" value="" autocomplete="off" v-model="pemail1">
        <span>@</span> 
        <input id="email02" name="email02" class="form-inline" list="domains" placeholder="도메인입력/선택" v-model="pemail2">
        <datalist id="domains">
            <option value="naver.com"></option>
			<option value="daum.net"></option>
			<option value="gmail.com"></option>
			<option value="yahoo.co.kr"></option>
		</datalist>
	</div>
    <div class="fieldlabel">
        <label for="mPhone1">전화번호</label>
    </div>
    <div class="formfield">
        <select id="mPhone1" name="mPhone1" v-model="ptel1">
            <option value="010" selected >010</option>
			<option value="011" >011</option>
			<option value="016" >017</option>
			<option value="018" >018</option>
			<option value="019" >019</option>
		</select>- 
        <input id="mPhone2" name="mPhone2" type="number" value=""
        size="4" maxlength="4" autocomplete="off" v-model="ptel2">- 
        <input id="mPhone3" name="mPhone3" type="number" value="" size="4" maxlength="4" autocomplete="off" v-model="ptel3">
	</div>
    <br />
    <fieldset class="scheduler-border" id="option">
        <legend class="scheduler-border">알레르기*</legend>
        <div class="formfield" >
            <input type="checkbox" name="hobby" value="대두" alt="취미" v-model="hobby">대두 
            <input type="checkbox" name="hobby" value="땅콩" alt="취미" v-model="hobby">땅콩 
            <input type="checkbox" name="hobby" value="우유" alt="취미" v-model="hobby">우유 
            <input type="checkbox" name="hobby" value="게" alt="취미" v-model="hobby">게 
            <br> <input type="checkbox" name="hobby" value="새우" alt="취미" v-model="hobby">새우 
            <input type="checkbox" name="hobby" value="참치" alt="취미" v-model="hobby"> 참치 
            <input type="checkbox" name="hobby" value="연어" alt="취미" v-model="hobby"> 연어 
            <input type="checkbox" name="hobby" value="쑥" alt="취미" v-model="hobby"> 쑥 
            <br>
            <input type="checkbox" name="hobby" value="소고기" alt="취미" v-model="hobby"> 소고기 
            <input type="checkbox" name="hobby" value="닭고기" alt="취미" v-model="hobby"> 닭고기 
            <input type="checkbox" name="hobby" value="돼지고기" alt="취미" v-model="hobby"> 돼지고기 
            <br> 
            <input type="checkbox" name="hobby" value="복숭아" alt="취미" v-model="hobby"> 복숭아 
            <input type="checkbox" name="hobby" value="민들레" alt="취미" v-model="hobby"> 민들레 
            <input type="checkbox" name="hobby" value="계란흰자" alt="취미" v-model="hobby"> 계란흰자
        </div>
    </fieldset>
    <div class="modal-footer">
        <button @click = "SignUp"  algin="right" type="button" class="btn btn-default" data-dismiss="modal">등록</button> 
        <!-- <input type="submit" class="btn btn-primary btn-sm" value="등록"> -->
        <!-- <button @click = "close_signup" algin="right" type="button" class="btn btn-default" data-dismiss="modal">Close</button> -->
        <router-link class="btn btn-default" data-dismiss="modal" to ="/">Close</router-link>
	</div>
</div>

</template>
<script>
import http from "C:/SSAFY2/vu/jg/src/http-common.js";
export default {
    name: "SignUp",
    data() {
        return {
            usernameOrEmail: "",
            password: "",
            pid: '',
            ppw1: '',
            ppw2: '',
            pname: '',
            paddr: '',
            pemail1: '',
            pemail2: '',
            ptel1: '',
            ptel2: '',
            ptel3: '',
            alinfo: [],
            hobby: [],
            date: '',
            login_show: false,
			Sign_Up_show: false,
			loginche:false,
			loginreal:false,
			booleanche:false,
			saveid:'',
        };
	},
	computed:{
		},
methods : {
    SignUp() {
        // alert("여기왔니?")
        for (let index = 0; index < this.hobby.length; index++) {
            if (index != 0) {
                this.alinfo = this.alinfo + ", ";
            }
            this.alinfo = this.alinfo + this.hobby[index];
        }
        // alert(this.pid)
        // alert(this.ppw1)
        // alert(this.pname)
        // alert(this.paddr)
        // alert(this.pemail1)
        // alert(this.pemail2)
        // alert(this.ptel1)
        // alert(this.ptel2)
        // alert(this.ptel3)
        // alert(this.alinfo)

        http
            .post('/SignUp', {
                id: this.pid,
                pw: this.ppw1,
                name: this.pname,
                addr: this.paddr,
                email: this.pemail1 + "@" + this.pemail2,
                tel: this.ptel1 + "-" + this.ptel2 + "-" + this.ptel3,
                alinfo: this.alinfo
            })
            .then(() => {
                alert("등록 처리를 하였습니다.");
                this.$router.push("/");

            });
        this.submitted = true;
    }
}
};
</script>