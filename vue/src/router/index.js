import Vue from 'vue'
import Router from 'vue-router'

import Write from '@/components/board/Write.vue'
import List from '@/components/board/List.vue'
import Update from '@/components/board/Update.vue'

import Remove from '@/components/board/Remove.vue'
import Research from '@/components/board/Research.vue'
import Join from '@/components/member/Join.vue'
import Login from '@/components/member/Login.vue'



Vue.use(Router)
export default new Router({
	mode:'history',
	routes: [
		
		{path:'/write' , name:'write' , component: Write},
		{path:'/list' , name:'list' , component:List},
		{path:'/update' , name:'update' , component:Update},
		{path:'/remove' , name:'remove' , component:Remove},
		{path:'/research' , name:'research' , component: Research},
		{path:'/join' , name:'join' , component: Join},
		{path:'/login' , name:'login' , component:Login},
		

	]
})