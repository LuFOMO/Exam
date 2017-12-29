<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />
<style>
.s-scroll-to-section-v1--bc {
  position: absolute;
  left: 50%;
  bottom: 0.625rem;
  z-index: 1;
  -webkit-transform: translate3d(-50%, 0, 0);
  transform: translate3d(-50%, 0, 0);
  text-align: center;
}
.g-padding-y-80--xs {
  padding-top: 5rem;
  padding-bottom: 5rem;
}
  .g-padding-y-125--sm {
    padding-top: 7.8125rem;
    padding-bottom: 7.8125rem;
  }
</style>
<section style="background-image: url('/img/exam/bg.png');">
	<div class="container" style="padding-top:100px">
	<div class="wrapper" style="padding-top:50px">
	<div class="row">
	<div class="col-xs-10 col-xs-offset-1 col-md-10 col-md-offset-1">
	
		<div class="col-md-3">
		<img class="img-responsive" src="/img/teach/t-1.png" alt="exam_before" style="width:150px">
		<h3>考前操作</h3>
		<p>可以新建考试：指定考试名称、开始时间
		   可以编辑自己创建的、未开始的考试，除了修改考试信息
		  还可以：上传试卷、学生名单导入、开启考试 </p>
		 <a class="btn btn-md" href="/teacher/exam/list" style="background-color:#D7855F;color:#fff">Go</a>
		</div>
		
		<div class="col-md-1"></div>
		
		<div class="col-md-3">
		<img class="img-responsive" src="/img/teach/t-2.png" alt="exam_modify" style="width:150px">
		<h3>考中管理</h3>
		<p>可以查看考试情况、可以管理学生信息，手工添加个别学生信息、可以解除学生登录锁定、可以添加或删除通知消息
		</p>
		<br>
		<div>
            <a href="#js__scroll-to-section" class="s-scroll-to-section-v1--bc g-margin-b-15--xs" style="position:static;bottom: 3.625rem;">
            <span class="g-color--white ti-angle-double-down btn btn-md" style="background-color:#D7855F;">GO</span> 
           </a>
           </div>
		</div>
		
		<div class="col-md-1"></div>
	
	
		<div class="col-md-3">
		<img class="img-responsive" src="/img/teach/t-3.png" alt="exam_student" style="width:150px">
		<h3>考后操作</h3>
		<p>主考教师（考试创建者）可以结束考试、主考教师可以打包下载学生提交文件、主考教师可以导出提交信息、如果管理员设置，主考教师可以清理和删除考试
		</p>
		 <a class="btn btn-md" href="/teacher/exam/after" style="background-color:#D7855F;color:#fff">Go</a>
		</div>
		<div class="col-md-1"></div>
	</div>
	</div>
	</div>
	</div>
</section>
<div style="background-image: url('../img/exam/bg.png');padding-top:80px">
	<div  id="js__scroll-to-section" class="container g-padding-y-80--xs g-padding-y-125--sm" >
	<div style="padding-top:100px;">
		<div class="row" style="padding-left:200px;">
		<div class="col-md-1"></div>
			<div class="col-md-4">
				<img class="img-responsive" alt="" src="/img/teach/t-g.svg" style="width:500px;">
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4 text-right">
				<h2>考试概况</h2>
				<p>查看已登录/未登录的学生总数<br>
				已提交/未提交文件的学生总数</p>
				<a class="btn btn-lg btn-primary" href="/teacher/get/student/message" style="color:#fff;">Go</a>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	
	<div style="padding-top:100px;">	
		<div class="row" style="padding-left:200px;">
		<div class="col-md-1 " ></div>
			<div class="col-md-4 text-left">
				<h2>学生信息</h2>
				<p>单个添加学生信息<br>
				查找学生信息</p>
				<a class="btn btn-lg btn-primary" href="/teacher/manage_student" style="color:#fff;">Go</a>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<img class="img-responsive" alt="" src="/img/teach/t-m.svg" style="width:500px;">
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	
	<div style="padding-top:100px;">
		<div class="row" style="padding-left:200px;">
		<div class="col-md-1" ></div>
			<div class="col-md-4">
				<img class="img-responsive" alt="" src="/img/teach/t-i.svg" style="width:500px;">
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4 text-right">
				<h2>解除锁定</h2>
				<p>查看学生登录IP地址<br>
				解除学生登录的IP绑定</p>
				<a class="btn btn-lg btn-primary" href="/teacher/manage_unlock" style="color:#fff;">Go</a>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	
	<div style="padding-top:100px;">	
		<div class="row" style="padding-left:200px;">
		<div class="col-md-1"></div>
			<div class="col-md-4 text-left">
				<h2>通知管理</h2>
				<p>添加或删除通知消息</p>
				<a class="btn btn-lg btn-primary" href="/teacher/manage/notify" style="color:#fff;">Go</a>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-4">
				<img class="img-responsive" alt="" src="/img/teach/t-q.svg" style="width:500px;">
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	</div>
</div>





<jsp:include page="footer.jsp" />
