<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" />

<section style="background-image:url('../img/exam/bg.png');" >
<br/>
<br/>
<br/>
<br/>
<br/>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-sm-6">
			<div class="thumbnail">
				<img alt="" src="../img/exam/teach.jpg">
			</div>
			<div class="caption">	
				<h3>教师管理</h3>
				<ul>
					<li><p>可以对教师用户进行增删改查操作，并可以指定特定教师作为系统管理员</p></li>
					<li><p>系统可以有多个管理员</p></li>
					<li><p>如果没有任何一个教师具有管理员身份，则默认管理员登录信息有效</p></li>
					<p class="masthead-button-links">
					<a class="btn btn-lg btn-primary btn-shadow" href="teacher">GO</a>
					</p>
				</ul>
			</div>
		</div>
		<div class="col-md-4 col-sm-6">
			<div class="thumbnail">
				<img alt="" src="../img/exam/clean.jpg">
			</div>
			<div class="caption">	
				<h3>考试清理</h3>	
				<ul>			
					<li><p>清除考试的相关数据，包括数据库中的信息、文件系统中的提交文件</p></li>
					<li><p>只有在主考教师已经打包下载学生提交文件后才可以进行</p></li>
					<li><p>清理后的考试可以删除</p></li>
					<p class="masthead-button-links">
					<a class="btn btn-lg btn-primary btn-shadow" href="exam">GO</a>
					</p>
				</ul>
			</div>
		</div>
		<div class="col-md-4 col-sm-6">
			<div class="thumbnail">
			<img alt="" src="../img/exam/config.jpg">
		</div>
			<div class="caption">	
			<h3>系统配置</h3>
			<ul>
				<li><p>设置一些全局性的系统选项，包括后台任务的时间周期、分页查询时的每页记录数、手动开启考试的时间阈值、学生上传文件字节数的有效范围等</p></li>
				<li><p>可以指定是否允许主考教师清理和删除考试。</p></li>
				<p class="masthead-button-links">
				<br/>
				<a class="btn btn-lg btn-primary btn-shadow" href="config">GO</a>
				</p>
			</ul>
			</div>
		</div>
</div>
</div>
</section>
<jsp:include page="footer.jsp" />
