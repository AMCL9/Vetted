package com.example.vetted.FragmentController;

import com.example.vetted.modells.Businesses;

import java.util.ArrayList;
import java.util.List;

public interface Fragmentinterface {
  void showMainFragment (List <Businesses> termRelatedBusinesses);
  void showMapFragment (ArrayList<Businesses> termRelatedBusinesses);
  void showRecyclerViewFragment (List<Businesses> businessesList);
  void showDetailsFragment ();
}
