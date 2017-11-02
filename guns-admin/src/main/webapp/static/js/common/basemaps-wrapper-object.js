/**
 * ztree插件的封装
 */
(function() {

    var $BaseMaps = function(domId, _map) {
        this.dom_id = domId;
        this.map = _map;
        this.layer = null;
        this.OnChange = null;
    };

    $BaseMaps.prototype = {
        /**
         * 初始化ztree
         */
        init : function() {
            var _self = this;
            _self.layer = L.esri.basemapLayer($("#" + _self.dom_id).children('option:selected').val()).addTo(this.map);

            $("#" + _self.dom_id).change(function () {
                if (_self.layer) {
                    _self.map.removeLayer(_self.layer);
                }

                _self.layer = L.esri.basemapLayer($(this).children('option:selected').val());
                _self.map.addLayer(_self.layer);
            })
        }
    };

    window.$BaseMaps = $BaseMaps;

}());