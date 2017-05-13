jQuery(document).ready(function(){
        jQuery('#hideShowFavoris').on('click', function(event) {        
             jQuery('#Favoris').toggle('show');
        });
    });

jQuery(document).ready(function(){
    jQuery('#hideShowSouhaits').on('click', function(event) {        
         jQuery('#Souhaits').toggle('show');
    });
});

jQuery(document).ready(function(){
    jQuery('#showAll').on('click', function(event) {        
         jQuery('#Favoris').show();
         jQuery('#Souhaits').show();
    });
});

jQuery(document).ready(function(){
    jQuery('#ajouterNomListe').on('click', function(event) {        
         jQuery('#newListe').toggle('show');
    });
});