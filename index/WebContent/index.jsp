<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/yuntu.tld" prefix="format" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <title>${title }</title>
    <style type="text/css">
        body{ background: #f3f3f3;  }
    </style>
</head>
<body>
<div class="container topSection" style="padding: 20px !important; background: #fff;">
    <nav class="detail_nav" style="margin-bottom: 30px;">
        <a href="/">全部分类</a>&nbsp;
        <c:if test="${currSubject.categoriesName1!=null }">
            <span>></span>&nbsp;
            <a href="/subject/list?label1=${currSubject.label1}">${currSubject.categoriesName1 }</a>&nbsp;
        </c:if>
        <c:if test="${currSubject.categoriesName2!=null }">
            <span>></span>&nbsp;
            <a href="/subject/list?label1=${currSubject.label1}&label2=${currSubject.label2}">${currSubject.categoriesName2 }</a>&nbsp;
        </c:if>
        <span>></span>&nbsp;
        <span style="color: #666;">${title}</span>
    </nav>
    <div class="pull-left">
        <a href="javascript:void(0);">
            <img class="img" id="coverImage"
                 src="${currSubject.cover}"
                 onerror="this.src='/img/cover/media.jpg';" onload="Zoom(this,600,340)">
            <i class="play-btn"></i>
        </a>
    </div>
    <div class="pull-right" style="width: 540px;position: relative;height: 340px;">
        <h3 class="album-title">${title}</h3>
        <p class="album-introduction">简介：${introduction}</p>
<br/>
        <p class="album-detail"><span>创建者：${userName}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>更新时间：<format:format pattern="yyyy-MM-dd " value="${currSubject.timeline}"/></span></p>
        <p class="album-detail">
            资源：${resource}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            浏览：${view}&nbsp;&nbsp;&nbsp;&nbsp;
             </p>
        <div class="album-play" style="position: absolute;bottom: 0px;">
            <c:if test="${user!=null}">
            <c:if test="${!button}">
                <c:if test="${!Concern}">
                    <button  onclick="favoriteDelete()"  class="btn btn-success" id="concernBtn">已关注</button>
                </c:if>
                <c:if test="${Concern}">
                    <button  onclick="favoriteSave()"  class="btn btn-success" id="concernBtn">立即关注</button>
                </c:if>
            </c:if>
            </c:if>
            <c:if test="${user==null}">
                <button  onclick="loginBook()"  class="btn btn-success" id="concernBtn">立即关注</button>
            </c:if>
            <c:if test="${button}">关注 :</c:if>
            &nbsp;&nbsp;&nbsp;&nbsp;
            成员:<span id="favoriteNUM">${follows}</span>人

        </div>
    </div>
</div>

<div class="container" style="margin-top: 10px;">
    <div class="middleSection" style="overflow: hidden;">
        <div class="view-list pull-left">
            <div class="item-list">
               <c:if test="${resourcesList==null}">
                    <p style="font-size:20px;width: 100%;text-align: center;">很抱歉，暂未收录资源！</p>
                </c:if>
                <c:forEach items="${resourcesList}" var="map">
                    <c:if test="${map['type']==1||map['type']==2}">
                        <div class="box-featured">
                            <div style="margin: 0 auto;">
                                <a href="/mediaAlbum/${map['target'].id}">
                                    <img src="${coverServer}/${map['target'].cover}"
                                         onerror="src='/img/cover/media.jpg';"
                                         onload="Zoom(this,190,107)"/>
                                </a>
                            </div>
                            <p class="wicket-title wicket-featured"><a href="/mediaAlbum/${map['target'].id}">${map['target'].title}</a></p>
                            <p class="wicket-hot">
                                <span class="pull-left"><i class="fa fa-heart"></i>${map['target'].favorite}</span>
                                <span class="pull-right"><i class="fa fa-eye"></i>${map['target'].view}</span>
                            </p>
                            <p class="wicket-detail">
                                <span class="pull-left">来源：${map['target'].uploadUsername}</span>
                                <c:if test="${map['open'] == 0}">
                                    <span class="pull-right" style="color: #2abe60">私有</span>
                                </c:if>
                            </p>
                        </div>
                    </c:if>

                    <c:if test="${map['type']==3}">
                        <div class="box-featured">
                            <div style="margin: 0 auto; position: relative;">
                                <a href="/document/view/${map['target'].id}">
                                    <img src="${coverServer}/${map['target'].cover}"
                                         onerror="src='/img/cover/media.jpg';"
                                         onload="Zoom(this,190,107)"/>
                                </a>
                                <div style="position: absolute; left: 4px; top: 1px;"><i class="fa fa-bookmark"
                                                                                         style="color: rgba(239, 120, 77, 0.85);font-size: 43px; position: relative;
                                 "><span style="color:#fff; position: absolute; left: 0; top:11px;
                                 width: 31px; display: block; text-align: center; font-size: 13px;">${map['target'].pages}P</span></i></div>
                            </div>
                            <p class="wicket-title wicket-featured"><a href="/document/view/${map['target'].id}">${map['target'].title}</a></p>
                            <p class="wicket-hot">
                                <span class="pull-left"><i class="fa fa-heart"></i>${map['target'].favorite}</span>
                                <span class="pull-right"><i class="fa fa-eye"></i>${map['target'].view}</span>
                            </p>
                            <p class="wicket-detail">
                                <span class="pull-left">来源：${map['target'].uploadUsername}</span>
                                <c:if test="${map['open'] == 0}">
                                    <span class="pull-right" style="color: #2abe60">私有</span>
                                </c:if>
                            </p>
                        </div>
                    </c:if>


                    <c:if test="${map['type']==4}">
                        <div class="box-featured">
                            <div style="margin: 0 auto; position: relative;">
                                <a href="/image/box?aid=${map['target'].id}&id=${map['target'].firstImageId}">
                                    <img src="${coverServer}${map['cover']}"
                                         onerror="src='/img/cover/media.jpg';"
                                         onload="Zoom(this,190,107)"/>
                                </a>
                                <div style="position: absolute; left: 4px; top: 1px;"><i class="fa fa-bookmark"
                                                                                         style="color: rgba(42, 190, 96, 0.85);font-size: 43px; position: relative;
                                 "><span style="color:#fff; position: absolute; left: 0; top:11px;
                                 width: 31px; display: block; text-align: center; font-size: 13px;">${map['imageCount']}P</span></i></div>
                            </div>
                            <p class="wicket-title wicket-featured"><a href="/image/box?aid=${map['target'].id}&id=${map['target'].firstImageId}">${map['target'].title}</a></p>
                            <p class="wicket-hot">
                                <span class="pull-left"><i class="fa fa-heart"></i>${map['target'].favorite}</span>
                                <span class="pull-right"><i class="fa fa-eye"></i>${map['target'].view}</span>
                            </p>
                            <p class="wicket-detail">
                                <span class="pull-left">来源：${map['target'].uploadUsername}</span>
                                <c:if test="${map['open'] == 0}">
                                    <span class="pull-right" style="color: #2abe60">私有</span>
                                </c:if>
                            </p>
                        </div>
                    </c:if>
                    <c:if test="${map['type']==5}">
                        <div class="box-featured" style="width: 210px;">
                            <div style="width: 190px; height: 107px; margin: 0 auto; background: #f7f7f7;">
                                <div style="margin: 0 auto;">
                                    <a href="/book/${map['target'].mid}">
                                        <img src="http://${bookCoverServer}/${map['target'].cover}"
                                             onerror="src='/img/cover/media.jpg';"
                                             onload="Zoom(this,81,107)"/></a>
                                </div>
                            </div>
                            <p class="wicket-title wicket-featured"><a href="/book/${map['target'].mid}"> ${map['target'].title}</a></p>
                            <p class="wicket-hot">作者：&nbsp;&nbsp;${map['target'].author}</p>
                            <p class="wicket-detail">${map['target'].publisher}</p>
                        </div>
                    </c:if>
                </c:forEach>
            </div>

        </div>

        <div class="pull-right recommend-list">
            <h2>相关推荐</h2>
            <div class="relate-container">
                <c:if test="${empty hotPage.content}">
                    <h4 style="font-weight:normal;font-size: 16px;">暂时没有相关的推荐...</h4>
                </c:if>
                <c:if test="${!empty hotPage.content}">
                    <ul>
                        <c:forEach items="${hotPage.content}" var="map" varStatus="status" begin="0" end="5">
                            <c:if test="${currSubject.id != map['id']}">
                                <li class="relate-li">
                                    <div class="relate_book_image">
                                        <a href="/subject/${map['id']}">
                                            <img src="${coverServer}/${map['cover']}"
                                                 onerror="src='/img/cover/media.jpg';"
                                                 onload="Zoom(this,268,172)"/></a>
                                        </a>
                                    </div>
                                    <div class="relate_subject_ifo">
                                        <div> <a href="/subject/${map['id']}" style="line-height:20px;">${map['title']}</a></div>
                                        <div></div>
                                    </div>
                                    <p class="wicket-hot">
                                        <span class="pull-left"><i class="fa fa-heart"></i>${map['target'].favorite}${map['follows']}</span>
                                        <span class="pull-right"><i class="fa fa-eye"></i>${map['target'].view}${map['view']}</span>
                                    </p>
                                </li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </c:if>
            </div>
        </div>
    </div>


</div>

<script type="text/javascript">

    function favoriteSave() {
        var uid = "${session.uid}";
        if(uid !=''){
            $.ajax({
                url: '/subject/collect.json?sid=${currSubject.id}&type=7',
                type: 'GET',
                success: function (data) {
                    $('#concernBtn').html('已关注').attr('onclick','javascript:favoriteDelete();');

                    $('#favoriteNUM').text(data.message);
                }
            });
        }
        else{
            loginBook();}
    }
    function favoriteDelete() {

        if(confirm('确认取消关注吗?'))
        {
            $.ajax({
                url:'/subject/delete.json?sid=${currSubject.id}&type=7',
                type: 'GET',
                success: function (data) {
                    $('#concernBtn').html('立即关注').attr('onclick','javascript:favoriteSave();');
                    $('#favoriteNUM').html(data.message);
                }
            });

        }
        else
        {
            return false;
        }


    }



</script>
</body>
</html>