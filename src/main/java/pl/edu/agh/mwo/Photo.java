package pl.edu.agh.mwo;

public class Photo {
	
	private String comment;

	public Photo(String comment) {
		this.comment = comment;
	}
	
	public Photo() {
		comment = "Nie dodano komentarza";
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
