
package com.sg.dvdlibrary.dto;

//import java.time.LocalDate;

import java.util.Objects;


public class DVD{

    private String title;    
    private String studio;
    private String MPAA_Rating;    
    private String userRating;
    private String releaseDate; 

    public DVD(String title, String studio, String MPAA_Rating, String userRating, String date){
        this.title = title;
        this.studio = studio;        
        this.MPAA_Rating = MPAA_Rating;        
        this.userRating = userRating;        
        this.releaseDate = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getMPAA_Rating() {
        return MPAA_Rating;
    }

    public void setMPAA_Rating(String MPAA_Rating) {
        this.MPAA_Rating = MPAA_Rating;
    }

    /**
     * @return the userRating
     */
    public String getUserRating() {
        return userRating;
    }

    /**
     * @param userRating the userRating to set
     */
    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.title);
        hash = 61 * hash + Objects.hashCode(this.studio);
        hash = 61 * hash + Objects.hashCode(this.MPAA_Rating);
        hash = 61 * hash + Objects.hashCode(this.userRating);
        hash = 61 * hash + Objects.hashCode(this.releaseDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DVD other = (DVD) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.studio, other.studio)) {
            return false;
        }
        if (!Objects.equals(this.MPAA_Rating, other.MPAA_Rating)) {
            return false;
        }
        if (!Objects.equals(this.userRating, other.userRating)) {
            return false;
        }
        return Objects.equals(this.releaseDate, other.releaseDate);
    }

    @Override
    public String toString() {
        return "DVD{" + "title=" + title + ", studio=" + studio + ", MPAA_Rating=" + MPAA_Rating + ", userRating=" + userRating + ", releaseDate=" + releaseDate + '}';
    }

    
    
}
