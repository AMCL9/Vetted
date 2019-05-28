package com.example.vetted.FragmentController;

import com.example.vetted.modells.Businesses;

import java.util.ArrayList;
import java.util.List;

public interface Fragmentinterface {
  void showMainFragment ();
  void showMapFragment (ArrayList<Businesses> list);
  void showDetailsFragment (String image, String [] otherImages, String name,
                            String alias, String phoneNumber, String rating,
                            Boolean open, String price, String url);
  void passBusinessSearch ();
  void passBusiDetails ();
  String passID (String id);
  String update (String string);



}
