<template>
<div>
  <div id="host-header">
        <h1 align = "center">업체 회원 가입</h1>
      </div>
        <fieldset>
        <legend>아이디 입력 </legend>
        <span><input v-model="cid" type="text" id="hostId" name="hostId" maxlength="20" value=""></span>
        </fieldset>
        <fieldset>
        <legend>패스워드 입력 </legend>
        <input  v-model="cpw" type="pw" id="userPw" name="hostPw" maxlength="20" autocomplete="off">
        <div><label for="hostCheck">패스워드확인</label></div>
        <div><input type="pw" id="hostPwCheck" name="hostPwCheck" maxlength="20" autocomplete="off"></div>
        </fieldset>
        <fieldset>
        <legend>이름 입력 </legend>
        <div><label for="hostName">이름</label></div>
        <div><input v-model="cname" type="text" id="hostName" name="hostName" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>닉네임 입력 </legend>
        <div><label for="nickName">닉네임</label></div>
        <div><input type="text" id="nickName" name="nickName" maxlength="20" value=""></div>
        </fieldset>
        <fieldset>
        <legend>이메일 입력 </legend>
        <div><input type="text" id="email01" name="email01" size="20" maxlength="20"
             value="" autocomplete="off"><span>@</span>
            <input id="email02" name="email02" list="domains" placeholder="도메인입력/선택">
            <select id="domains" style="height: 21.5px;vertical-align: middle;">
                <option value="직접입력">직접입력</option>
                <option value="naver.com">naver.com</option>
                <option value="daum.net">daum.net</option>
                <option value="gmail.com">gmail.com</option>
                <option value="yahoo.co.kr">yahoo.co.kr</option>
            </select>
        </div>
            <div><label>이메일수신</label></div>
            <div>
                <input type="radio" name="emailYn" value="Y" checked>수신
                <input type="radio" name="emailYn" value="N">미수신
            </div>
        </fieldset>
        <fieldset>
        <legend>연락처 입력 </legend>
			<div>
				<select id="mPhone1" name="mPhone1">
					<option value="010" selected>010</option>
					<option value="011">011</option>
					<option value="016">017</option>
					<option value="018">018</option>
					<option value="019">019</option>
				</select>-
				<input type="number" value="" size="4" maxlength="4" autocomplete="off">-
				<input type="number" value="" size="4" maxlength="4" autocomplete="off">
			</div>
			<div><label>SMS수신</label></div>
			<div>
				<input type="radio" name="smsYn" value="Y" checked>수신
				<input type="radio" name="smsYn" value="N">미수신
			</div>
        </fieldset>
        <fieldset>
        <legend>업체주소 입력 </legend>
            <input type="text" name="pwd" size="20" placeholder="시/도 입력 " autocomplete="address-level1" >
            <input type="text" name="pwd" size="20" placeholder="시/군/구 입력" autocomplete="address-level2">
        <input type="text" name="pwd" size="20" placeholder="상세주소 입력" autocomplete="address-line1" style="float: none;width: 78%;">
                <button >등록</button><br/><br/>
        </fieldset>
        <fieldset>
        <legend>사업자등록번호 입력 </legend>
                <input type="text" name="pwd" size="20" placeholder="사업자등록번호 입력">
                <button >등록</button><br/><br/>
        </fieldset>
        <fieldset>
        <legend>업체종류 선택 </legend>
            <div class="formfield">
                <input type="radio" name="hosttype" value="숙박" alt="업체종류" >숙박
                <input type="radio" name="hosttype" value="음식점" alt="업체종류" >음식점
                <input type="radio" name="hosttype" value="교통" alt="업체종류" >교통
                <input type="radio" name="hosttype" value="기타" alt="업체종류">기타
                <input type="text" placeholder="직접입력" >
                    <button >등록</button><br/><br/>
            </div>
        </fieldset>
        <fieldset>
        <legend>업체소개 등록 </legend>
            <textarea name="info" id="hostinfo" placeholder="업체 소개를 입력해 주세요" cols="30" rows="10" style="width: 98%;"></textarea><br/>
            <button style="float: right;">저장</button><br/><br/>
        </fieldset>
        <div class="btnfield" style="text-align: center">
            <input @click="join" type="submit" value="회원가입">
        </div>
</div>
</template>
<script>
import axios from "axios"
export default{
	data(){
		return {
			context: 'http://localhost:8080/',
			cid: '',
			cpw: '',
			cname:''

		}
	},
	methods:{
		join(){
			let url = `${this.context}/join`
			alert(`${this.cid}`)
			let data={
				cid : this.cid,
				cpw : this.cpw,
				cname: this.cname

			}
			let headers = {
              'authorization': 'JWT fefege..',
              'Accept' : 'application/json',
              'Content-Type': 'application/json'
			}
			axios.post(url,data, headers)
			.then(res=>{
                alert(res)
				this.$router.push({path:'/login'})
			}).catch(()=>{
				alert('실패')
			})
		}
	}
}
</script>
<style scoped>
</style>