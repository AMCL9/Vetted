package com.example.vetted.FragmentController;

import com.example.vetted.modells.Businesses;

import java.util.List;

public interface Fragmentinterface {
  void showMainFragment ();
  void showMapFragment (Double lat, Double lon);
  void showRecyclerViewFragment (List<Businesses> businessesList);
  void showDetailsFragment ();
}
