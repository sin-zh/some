app.controller('baseController', function ($scope) {
    //定义插件
    //分页控件配置currentPage:当前页   totalItems :总记录数  itemsPerPage:每页记录数  perPageOptions :分页选项  onChange:当页码变更后自动触发的方法
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();
        }
    };


    $scope.getSelectedId = function ($event, id) {
        if ($event.target.checked) {
            $scope.selectedId.push(id);
        } else {
            if ($scope.selectedId.indexOf(id) > 0) {
                $scope.selectedId.splice($scope.selectedId.indexOf(id), 1)
            }
        }

    }
})