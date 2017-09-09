package fr.ocelet.model.kmlconvert;

import fr.ocelet.datafacer.InputDataRecord;
import fr.ocelet.datafacer.OutputDataRecord;
import fr.ocelet.datafacer.ocltypes.Shapefile;
import fr.ocelet.model.kmlconvert.Cluster;
import fr.ocelet.runtime.entity.Entity;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;

@SuppressWarnings("all")
public class Clusters_shp extends Shapefile {
  public Clusters_shp() {
    super("data/Clusters_1km_1+.shp","EPSG:4326");
  }
  
  public List<Cluster> readAllCluster() {
    List<Cluster> _elist = new List<Cluster>();
    for (InputDataRecord _record : this) {
      _elist.add(createClusterFromRecord(_record));
     }
    resetIterator();
    return _elist;
  }
  
  public List<Cluster> readAll() {
    return readAllCluster();
  }
  
  public Cluster createClusterFromRecord(final InputDataRecord _rec) {
                      	    Cluster _entity = new Cluster();
    _entity.setProperty("id",readString("LOC_ID"));
    _entity.setProperty("geom",readMultiPolygon("geom"));
    _entity.setProperty("sdate",readString("START_DATE"));
    _entity.setProperty("edate",readString("END_DATE"));
    _entity.setProperty("cas",readInteger("NUMBER_LOC"));
    return _entity;
  }
  
  public HashMap<String, String> getMatchdef() {
    HashMap<String, String> hm = new HashMap<String, String>();
    hm.put("LOC_ID","java.lang.String");
    hm.put("geom","fr.ocelet.runtime.geom.ocltypes.MultiPolygon");
    hm.put("START_DATE","java.lang.String");
    hm.put("END_DATE","java.lang.String");
    hm.put("NUMBER_LOC","java.lang.Integer");
    return hm;
  }
  
  public List<Cluster> readFilteredCluster(final String _filt) {
    setFilter(_filt);
    return readAllCluster();
  }
  
  public OutputDataRecord createRecord(final Entity ety) throws IllegalArgumentException {
    OutputDataRecord odr = createOutputDataRec();
    if (odr != null) {
    odr.setAttribute("LOC_ID",((Cluster) ety).getId());
    odr.setAttribute("geom",((Cluster) ety).getGeom());
    odr.setAttribute("START_DATE",((Cluster) ety).getSdate());
    odr.setAttribute("END_DATE",((Cluster) ety).getEdate());
    odr.setAttribute("NUMBER_LOC",((Cluster) ety).getCas());
    }
    return odr;
  }
}
