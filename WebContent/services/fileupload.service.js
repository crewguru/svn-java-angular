
(function () {
    'use strict';

    angular
        .module('app')
        .service('fileUpload', ['$http','$rootScope', function ($http,$rootScope) {
        	$rootScope.uploadsuccess=false;
            this.uploadFileToUrl = function(file, uploadUrl,imagetype,callback){
            	
            	//alert('here');
            	//$rootScope.uploadsuccess=true;
            	//return true;
            	
               var fd = new FormData();
               fd.append('file', file);
               fd.append('userId', $rootScope.globals.currentUser.username);
               fd.append('imageType', imagetype);
            
               $http.post(uploadUrl, fd, {
                  transformRequest: angular.identity,
                  headers: {'Content-Type': undefined}
               })
            
               .success(function(resp){
            	   //$rootScope.uploadsuccess=true;
            	   console.log('success :'+resp);
            	   //alert(imagetype);
            	   console.log('imageType :'+imagetype);
            	   if(imagetype == 'profileimage')
            		   $rootScope.globals.currentUser.userprofilepic=resp.picpath +'?decache=' + Math.random();
            	   if(imagetype == 'bgimage')
            		   {
            		   	//alert(' here...');
            		   		$rootScope.globals.currentUser.bgimage=resp.picpath + '?decache=' + Math.random();
            		   }
            	   //alert($rootScope.uploadsuccess);
            	   //alert($rootScope.globals.currentUser.userprofilepic);
            	   //response=resp.data;
            	   console.log(' bgimage :'+$rootScope.globals.currentUser.bgimage);
            	   callback('true');
            	   
               })
            
               .error(function(data){
            	   console.log("error"+data);
            	   callback('false');
            	   //error=resp.data;
               });
            }
         }]);
    
})();