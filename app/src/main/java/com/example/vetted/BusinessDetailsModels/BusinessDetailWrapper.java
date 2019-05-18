package com.example.vetted.BusinessDetailsModels;

import com.example.vetted.modells.Categories;
import com.example.vetted.modells.Coordinates;

public class BusinessDetailWrapper {


    public BusinessDetailWrapper(String id) {
        this.id = id;
    }

    private Hours[] hours;

        private String image_url;

        private String rating;

        private Coordinates coordinates;

        private String review_count;

        private String[] transactions;

        private String[] photos;

        private Special_hours[] special_hours;

        private String url;

        private boolean is_claimed;

        private String display_phone;

        private String phone;

        private String price;

        private String name;

        private String alias;

        private Location location;

        private String id;

        private Categories[] categories;

        private boolean is_closed;

        public Hours[] getHours ()
        {
            return hours;
        }

        public void setHours (Hours[] hours)
        {
            this.hours = hours;
        }

        public String getImage_url ()
        {
            return image_url;
        }

        public void setImage_url (String image_url)
        {
            this.image_url = image_url;
        }

        public String getRating ()
        {
            return rating;
        }

        public void setRating (String rating)
        {
            this.rating = rating;
        }

        public Coordinates getCoordinates ()
        {
            return coordinates;
        }

        public void setCoordinates (Coordinates coordinates)
        {
            this.coordinates = coordinates;
        }

        public String getReview_count ()
        {
            return review_count;
        }

        public void setReview_count (String review_count)
        {
            this.review_count = review_count;
        }

        public String[] getTransactions ()
        {
            return transactions;
        }

        public void setTransactions (String[] transactions)
        {
            this.transactions = transactions;
        }

        public String[] getPhotos ()
        {
            return photos;
        }

        public void setPhotos (String[] photos)
        {
            this.photos = photos;
        }

        public Special_hours[] getSpecial_hours ()
        {
            return special_hours;
        }

        public void setSpecial_hours (Special_hours[] special_hours)
        {
            this.special_hours = special_hours;
        }

        public String getUrl ()
        {
            return url;
        }

        public void setUrl (String url)
        {
            this.url = url;
        }

        public boolean getIs_claimed ()
        {
            return is_claimed;
        }

        public void setIs_claimed (boolean is_claimed)
        {
            this.is_claimed = is_claimed;
        }

        public String getDisplay_phone ()
        {
            return display_phone;
        }

        public void setDisplay_phone (String display_phone)
        {
            this.display_phone = display_phone;
        }

        public String getPhone ()
        {
            return phone;
        }

        public void setPhone (String phone)
        {
            this.phone = phone;
        }

        public String getPrice ()
        {
            return price;
        }

        public void setPrice (String price)
        {
            this.price = price;
        }

        public String getName ()
        {
            return name;
        }

        public void setName (String name)
        {
            this.name = name;
        }

        public String getAlias ()
        {
            return alias;
        }

        public void setAlias (String alias)
        {
            this.alias = alias;
        }

        public Location getLocation ()
        {
            return location;
        }

        public void setLocation (Location location)
        {
            this.location = location;
        }

        public String getId ()
        {
            return id;
        }

        public void setId (String id)
        {
            this.id = id;
        }

        public Categories[] getCategories ()
        {
            return categories;
        }

        public void setCategories (Categories[] categories)
        {
            this.categories = categories;
        }

        public boolean getIs_closed ()
        {
            return is_closed;
        }

        public void setIs_closed (boolean is_closed)
        {
            this.is_closed = is_closed;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [hours = "+hours+", image_url = "+image_url+", rating = "+rating+", coordinates = "+coordinates+", review_count = "+review_count+", transactions = "+transactions+", photos = "+photos+", special_hours = "+special_hours+", url = "+url+", is_claimed = "+is_claimed+", display_phone = "+display_phone+", phone = "+phone+", price = "+price+", name = "+name+", alias = "+alias+", location = "+location+", id = "+id+", categories = "+categories+", is_closed = "+is_closed+"]";
        }
    }

