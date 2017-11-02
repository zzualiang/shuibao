@/*
    地图底图切换标签的参数说明:

    name : 查询条件的名称
    id : 查询内容的input框id
@*/

<div class="leaflet-bar basemaps-wrapper input-group">
    <div class="input-group-btn">
        <button data-toggle="dropdown" class="btn btn-white dropdown-toggle" type="button">
            底图
        </button>
    </div>
    <select class="form-control" name="basemaps" id="${id}">
        @if(basemap == "Topographic"){
        <option value="Topographic" selected="selected">地形渲染图</option>
        @}else{
        <option value="Topographic">地形渲染图</option>
        @}

        @if(basemap == "Streets"){
        <option value="Streets" selected="selected">道路矢量图</option>
        @}else{
        <option value="Streets">道路矢量图</option>
        @}

        @if(basemap == "Imagery"){
        <option value="Imagery" selected="selected">高清影像图</option>
        @}else{
        <option value="Imagery">高清影像图</option>
        @}

    </select>
</div>