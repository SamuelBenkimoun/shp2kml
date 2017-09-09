package fr.ocelet.model.kmlconvert;

import fr.ocelet.model.kmlconvert.KML_export;
import fr.ocelet.runtime.entity.AbstractEntity;
import fr.ocelet.runtime.entity.Hproperty;
import fr.ocelet.runtime.geom.ocltypes.MultiPolygon;
import fr.ocelet.runtime.ocltypes.Date;

@SuppressWarnings("all")
public class Cluster extends AbstractEntity {
  public void setGeom(final MultiPolygon geom) {
    setProperty("geom",geom);
  }
  
  public MultiPolygon getGeom() {
    return getProperty("geom");
  }
  
  public void setId(final String id) {
    setProperty("id",id);
  }
  
  public String getId() {
    return getProperty("id");
  }
  
  public void setDdebut(final Date ddebut) {
    setProperty("ddebut",ddebut);
  }
  
  public Date getDdebut() {
    return getProperty("ddebut");
  }
  
  public void setDfin(final Date dfin) {
    setProperty("dfin",dfin);
  }
  
  public Date getDfin() {
    return getProperty("dfin");
  }
  
  public void setSdate(final String sdate) {
    setProperty("sdate",sdate);
  }
  
  public String getSdate() {
    return getProperty("sdate");
  }
  
  public void setEdate(final String edate) {
    setProperty("edate",edate);
  }
  
  public String getEdate() {
    return getProperty("edate");
  }
  
  public void setCas(final Integer cas) {
    setProperty("cas",cas);
  }
  
  public Integer getCas() {
    return getProperty("cas");
  }
  
  public void initDate() {
    this.setDdebut(Date.fromString("yyyy/MM/dd", this.getSdate()));
    this.setDfin(Date.fromString("yyyy/MM/dd", this.getEdate()));
  }
  
  public void outputKml(final Date ddate, final KML_export kml) {
    String _id = this.getId();
    String _plus = ("Cluster" + _id);
    String _plus_1 = (_plus + "_");
    String id = (_plus_1 + ddate);
    String style = "st";
    Date deb = ddate;
    Date fin = this.getDfin();
    kml.addGeometry(style, id, deb, fin, this.getGeom(), style, 0);
  }
  
  public Cluster() {
    super();
    defProperty("geom",new Hproperty<MultiPolygon>());
    setGeom(new MultiPolygon());
    defProperty("id",new Hproperty<String>());
    setId(new String());
    defProperty("ddebut",new Hproperty<Date>());
    setDdebut(new Date());
    defProperty("dfin",new Hproperty<Date>());
    setDfin(new Date());
    defProperty("sdate",new Hproperty<String>());
    setSdate(new String());
    defProperty("edate",new Hproperty<String>());
    setEdate(new String());
    defProperty("cas",new Hproperty<Integer>());
    setCas(new Integer("0"));
  }
}
