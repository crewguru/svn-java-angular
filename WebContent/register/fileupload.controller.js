(function () {
    'use strict';

    angular
        .module('app')

        .controller('fileUploadCtl', ['$scope','$rootScope', 'fileUpload', function($scope, $rootScope, fileUpload){
        	var vm=this;
        	
        	$scope.resp=false;
        	
        	$scope.uploadProgress=false;
        	
        	$scope.uploadinfo='';
        	
        	$scope.resetValues = function(){
        		$scope.resp=false;
        		$scope.uploadProgress=false;
        		$scope.myFile=null;
        	}
        	
            $scope.uploadFile = function(imagetype){
               var file = $scope.myFile;
            
               //console.log('file is ' );
              // console.dir(file);
               $scope.uploadProgress=true;
               var uploadUrl = "crewdata/data/fileupload";
               fileUpload.uploadFileToUrl(file, uploadUrl,imagetype, function (result){
            	   
            	   //alert(" Result is :"+result);
            	   $scope.uploadProgress=false;
                   if(result)
                	   {
                	   	$scope.resp=true;
                	   	$scope.uploadinfo='File has been uploaded successfully! ';
                	    
                	   }else
            		   {
                		   $scope.resp=false;
                			$scope.uploadinfo='Error uploading file! Try again.';
            		   }
            	   
            	   
               });
               
              
               
               //alert(vm.resp);
               
            };
            
            
            
         }]);
    
})();