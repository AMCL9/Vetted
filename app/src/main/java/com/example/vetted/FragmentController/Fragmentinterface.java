package com.example.vetted.FragmentController;

import com.example.vetted.modells.Businesses;

import java.util.ArrayList;
import java.util.List;

public interface Fragmentinterface {
  void showMainFragment ();
  void showMapFragment ();
  void showDetailsFragment ();
  void passBusinessSearch ();
  void passID (String id);
  String update (String string);


}
