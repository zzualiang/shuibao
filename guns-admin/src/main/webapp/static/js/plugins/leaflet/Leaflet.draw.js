/**
 * Leaflet.draw assumes that you have already included the Leaflet library.
 */
L.drawVersion = '0.4.2';
/**
 * @class L.Draw
 * @aka Draw
 *
 *
 * To add the draw toolbar set the option drawControl: true in the map options.
 *
 * @example
 * ```js
 *      var map = L.map('map', {drawControl: true}).setView([51.505, -0.09], 13);
 *
 *      L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
 *          attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
 *      }).addTo(map);
 * ```
 *
 * ### Adding the edit toolbar
 * To use the edit toolbar you must initialise the Leaflet.draw control and manually add it to the map.
 *
 * ```js
 *      var map = L.map('map').setView([51.505, -0.09], 13);
 *
 *      L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
 *          attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
 *      }).addTo(map);
 *
 *      // FeatureGroup is to store editable layers
 *      var drawnItems = new L.FeatureGroup();
 *      map.addLayer(drawnItems);
 *
 *      var drawControl = new L.Control.Draw({
 *          edit: {
 *              featureGroup: drawnItems
 *          }
 *      });
 *      map.addControl(drawControl);
 * ```
 *
 * The key here is the featureGroup option. This tells the plugin which FeatureGroup contains the layers that
 * should be editable. The featureGroup can contain 0 or more features with geometry types Point, LineString, and Polygon.
 * Leaflet.draw does not work with multigeometry features such as MultiPoint, MultiLineString, MultiPolygon,
 * or GeometryCollection. If you need to add multigeometry features to the draw plugin, convert them to a
 * FeatureCollection of non-multigeometries (Points, LineStrings, or Polygons).
 */
L.Draw = {};

/**
 * @class L.drawLocal
 * @aka L.drawLocal
 *
 * The core toolbar class of the API — it is used to create the toolbar ui
 *
 * @example
 * ```js
 *      var modifiedDraw = L.drawLocal.extend({
 *          draw: {
 *              toolbar: {
 *                  buttons: {
 *                      polygon: 'Draw an awesome polygon'
 *                  }
 *              }
 *          }
 *      });
 * ```
 *
 * The default state for the control is the draw toolbar just below the zoom control.
 *  This will allow map users to draw vectors and markers.
 *  **Please note the edit toolbar is not enabled by default.**
 */
L.drawLocal = {
	// format: {
	// 	numeric: {
	// 		delimiters: {
	// 			thousands: ',',
	// 			decimal: '.'
	// 		}
	// 	}
	// },
	draw: {
		toolbar: {
			// #TODO: this should be reorganized where actions are nested in actions
			// ex: actions.undo  or actions.cancel
			actions: {
				title: '结束',
				text: '结束'
			},
			finish: {
				title: '完成',
				text: '完成'
			},
			undo: {
				title: '删除上一个点',
				text: '删除上一个点'
			},
			buttons: {
				polyline: '线段',
				polygon: '多边形',
				rectangle: '矩形',
				circle: '圆',
				marker: '点',
				circlemarker: '圆点'
			}
		},
		handlers: {
			circle: {
				tooltip: {
					start: '点击并拖动完成'
				},
				radius: 'Radius'
			},
			circlemarker: {
				tooltip: {
					start: '点击地图添加点'
				}
			},
			marker: {
				tooltip: {
					start: '点击地图添加点'
				}
			},
			polygon: {
				tooltip: {
					start: '点击地图开始添加',
					cont: '点击继续添加节点',
					end: '点击起点完成图形'
				}
			},
			polyline: {
				error: '<strong>Error:</strong> shape edges cannot cross!',
				tooltip: {
                    start: '点击地图开始添加',
                    cont: '点击继续添加节点',
                    end: '点击起点完成图形'
				}
			},
			rectangle: {
				tooltip: {
					start: '点击并拖动完成图形'
				}
			},
			simpleshape: {
				tooltip: {
					end: 'Release mouse to finish drawing.'
				}
			}
		}
	},
	edit: {
		toolbar: {
			actions: {
				save: {
					title: '保存更改',
					text: '保存'
				},
				cancel: {
					title: '结束编辑，取消所有更改',
					text: '取消'
				},
				clearAll:{
					title: '清除所有的更改',
					text: '清除'
				}
			},
			buttons: {
				edit: '编辑',
				editDisabled: '没有要编辑的图层',
				remove: '删除图层',
				removeDisabled: ''
			}
		},
		handlers: {
			edit: {
				tooltip: {
					text: '拖动节点',
					subtext: '点击取消'
				}
			},
			remove: {
				tooltip: {
					text: '点击删除要素'
				}
			}
		}
	}
};
