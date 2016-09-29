(function () {
    'use strict';
    
    angular
    .module('app')
    .filter('intialStart', function() {
	    return function(input, start) {
	        start = +start; //parse to int
	        if (!input || !input.length) { return; }
	        return input.slice(start);
	    }
	})
    
    
    

	/*.controller('ModalController', ModalController);

    function ModalController(ModalService) {
        var vm = this;

        vm.openModal = openModal;
        vm.closeModal = closeModal;

        initController();

        function initController() {
            vm.bodyText = 'This text can be updated in modal 1';
        }
        
        function openModal(id){
            ModalService.Open(id);
        }

        function closeModal(id){
            ModalService.Close(id);
        }
    }*/
    
})();