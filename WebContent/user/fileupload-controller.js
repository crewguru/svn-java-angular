(function () {
    'use strict';

    angular
        .module('app')
        .controller('FileUploadController', function ($scope) {
            $scope.createFileUploadDialog = function () {
               // ngDialog.open({ template: 'user/modal.html', className: 'ngdialog-theme-default' });
            };
        });
   
        /*.controller('FileUploadController', ['$scope', 'createDialog', function($scope, createDialogService) {
        	
        	$scope.launchSimpleModal = function() {
        		createDialog('/user/fileupload.dialog.view.html', {
                    id: 'filuploadDialog',
                    title: 'Upload Contest Image',
                    backdrop: true,
                    success: { label: 'Upload', fn: uploadSuccess },
                    cancel: { label: 'Cancel' },
                });
    		};
        	
        }]);*/
      /*.controller('FileUploadController', FileUploadController);
    
  FileUploadController.$inject = ['UserService', 'ModalService', '$rootScope','$location'];
    
    function FileUploadController(){
    	 var vm = this;
    	
    	 vm.createFileUploadDialog = createFileUploadDialog;
         vm.uploadme = {};
         vm.uploadme.src = "";
         

       function createFileUploadDialog() {

    	   ModalService.showModal({
               templateUrl: 'modal.html',
               controller: "FileUploadController"
           }).then(function(modal) {
               modal.element.modal();
               modal.close.then(function(result) {
            	   $rootScope.message = "You said " + result;
               });
           });
      }

      function uploadSuccess() {
           console.log(vm.uploadme);
               //need to call to the backend        
      }
    	
    }*/

})();