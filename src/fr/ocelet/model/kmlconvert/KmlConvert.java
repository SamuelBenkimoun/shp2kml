package fr.ocelet.model.kmlconvert;

import fr.ocelet.model.kmlconvert.Cluster;
import fr.ocelet.model.kmlconvert.Clusters_shp;
import fr.ocelet.model.kmlconvert.KML_export;
import fr.ocelet.runtime.model.AbstractModel;
import fr.ocelet.runtime.ocltypes.Color;
import fr.ocelet.runtime.ocltypes.List;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class KmlConvert extends AbstractModel {
  public KmlConvert() {
    super("KmlConvert");
  }
  
  public static void main(final String[] args) {
    KmlConvert model_KmlConvert = new KmlConvert();
    model_KmlConvert.run_KmlConvert();
  }
  
  public void run_KmlConvert() {
    InputOutput.<String>println("Model KmlConvert ready to run");
    Clusters_shp clShp = new Clusters_shp();
    List<Cluster> cluster_Shp = clShp.readAll();
    for (final Cluster cl : cluster_Shp) {
      cl.initDate();
    }
    KML_export kmln = new KML_export();
    List<Color> plt = this.colorRange(1, "dem");
    kmln.defStyleRange("st", Double.valueOf(2.0), plt, Double.valueOf((-0.2)));
    for (final Cluster p : cluster_Shp) {
      {
        p.initDate();
        p.outputKml(p.getDdebut(), kmln);
      }
    }
    InputOutput.<String>println("");
    InputOutput.<String>println("Saving kml file...");
    kmln.saveAsKml();
    InputOutput.<String>println("Done.");
  }
  
  public void simulate(final HashMap<String, Object> in_params) {
    run_KmlConvert();
  }
}
