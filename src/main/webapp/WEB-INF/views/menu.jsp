<style>
    .dropbtn {
        background-color: #04AA6D;
        color: white;
        padding: 16px;
        font-size: 16px;
        border: none;
    }

    .dropdown {
        position: relative;
        display: inline-block;
    }

    .dropdown-content {
        display: none;
        position: absolute;
        background-color: #f1f1f1;
        min-width: 160px;
        box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
        z-index: 1;
    }

    .dropdown-content a {
        color: black;
        padding: 12px 16px;
        text-decoration: none;
        display: block;
    }

    .dropdown-content a:hover {background-color: #ddd;}

    .dropdown:hover .dropdown-content {display: block;}

    .dropdown:hover .dropbtn {background-color: #3e8e41;}
</style>

<div class="dropdown">
    <button class="dropbtn">MAIN</button>
    <div class="dropdown-content">
        <a href="${pageContext.request.contextPath}/index">index</a>
        <a href="${pageContext.request.contextPath}/some-unknown-url">404</a>
    </div>
</div>

<div class="dropdown">
    <button class="dropbtn">manufacturers</button>
    <div class="dropdown-content">
        <a href="${pageContext.request.contextPath}/manufacturers">get ALL</a>
        <a href="${pageContext.request.contextPath}/manufacturers/add">create NEW</a>
    </div>
</div>

<div class="dropdown">
    <button class="dropbtn">cars</button>
    <div class="dropdown-content">
        <a href="${pageContext.request.contextPath}/cars">get ALL</a>
        <a href="${pageContext.request.contextPath}/cars/add">create NEW</a>
    </div>
</div>

<div class="dropdown">
    <button class="dropbtn">drivers</button>
    <div class="dropdown-content">
        <a href="${pageContext.request.contextPath}/drivers">get ALL</a>
        <a href="${pageContext.request.contextPath}/drivers/add">create NEW</a>
    </div>
</div>

<a href="${pageContext.request.contextPath}/drivers/cars">
    <button style="color: red">MY CARS</button>
</a>

<a href="${pageContext.request.contextPath}/logout">
    <button style="color: red">LOGOUT</button>
</a>