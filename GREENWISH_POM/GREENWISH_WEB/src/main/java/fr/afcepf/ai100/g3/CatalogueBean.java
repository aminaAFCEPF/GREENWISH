package fr.afcepf.ai100.g3;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import fr.afcepf.ai100.g3.entities.RepeatPaginator;

@ManagedBean(name = "mbCatalogue")
@ViewScoped
public class CatalogueBean {

	@EJB
	private IDaoParticipant proxyDaoParticipant;
	
	@EJB
	private IBusinessCatalogue proxyCatalogue;
	@EJB
	private IBusinessFavoris proxyFavoris;



	@ManagedProperty(value = "#{mbCnx}")
	private ConnexionBean mbCnx;
	@ManagedProperty(value = "#{mbRechercherObjet}")
	private RechercheBean mbRecherche;

	private List<Objet> objets;
	private RepeatPaginator paginator;

	@PostConstruct
	public void init() {
		if (mbRecherche.isSetDomaine(mbRecherche.getSelectedDomaine().getIddomaine()) 
				|| mbRecherche.isSetCategorie(mbRecherche.getSelectedCategorie().getIdcategorie())
				|| mbRecherche.isSetSousCategorie(mbRecherche.getSelectedSousCategorie().getIdsouscategorie())
				|| mbRecherche.isSetValeur(mbRecherche.getSelectedValeur().getIdvaleur())) {
			objets = mbRecherche.getResultatRecherche();
		}else{
			objets = proxyCatalogue.afficherTousLesObjets();
		}
		paginator = new RepeatPaginator(objets);
	}

	public void ajouterFavoris(Objet objet) {
		Favoris fav = new Favoris(objet);
		List<Favoris> favoris = proxyFavoris.afficherFavorisByIdParticipant(mbCnx.getParticipant().getIdparticipant());
		mbCnx.getParticipant().setFavoris(favoris);
		fav.getParticipants().add(mbCnx.getParticipant());
		mbCnx.getParticipant().getFavoris().add(fav);
		//proxyDaoPart.updateParticipant(mbCnx.getParticipant());
		proxyFavoris.ajouterFavoris(fav);
		Participant part = mbCnx.getParticipant();
		part.getFavoris().add(fav);
	}

	public String formatDescription(Objet objet, String description) {
		String output = objet.getDescription();

		description = mbRecherche.getProxyBusinessRecherche().RemplirEspaces(objet, output);

		return description;
	}

	public IBusinessCatalogue getProxyCatalogue() {
		return proxyCatalogue;
	}

	public void setProxyCatalogue(IBusinessCatalogue proxyCatalogue) {
		this.proxyCatalogue = proxyCatalogue;
	}

	public List<Objet> getObjets() {
		return objets;
	}

	public void setObjets(List<Objet> objets) {
		this.objets = objets;
	}

	public RepeatPaginator getPaginator() {
		return paginator;
	}

	public void setPaginator(RepeatPaginator paginator) {
		this.paginator = paginator;
	}

	public IBusinessFavoris getProxyFavoris() {
		return proxyFavoris;
	}

	public void setProxyFavoris(IBusinessFavoris proxyFavoris) {
		this.proxyFavoris = proxyFavoris;
	}

	public ConnexionBean getMbCnx() {
		return mbCnx;
	}

	public void setMbCnx(ConnexionBean mbCnx) {
		this.mbCnx = mbCnx;
	}


	public IDaoParticipant getProxyDaoParticipant() {
		return proxyDaoParticipant;
	}

	public void setProxyDaoParticipant(IDaoParticipant proxyDaoParticipant) {
		this.proxyDaoParticipant = proxyDaoParticipant;
	}
	
	


	public RechercheBean getMbRecherche() {
		return mbRecherche;
	}

	public void setMbRecherche(RechercheBean mbRecherche) {
		this.mbRecherche = mbRecherche;
	}

}
