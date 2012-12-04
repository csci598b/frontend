package edu.mines.csci598.recycler.frontend.items;

import org.apache.log4j.Logger;

import edu.mines.csci598.recycler.frontend.graphics.ResourceManager;

public enum RecyclableType {

    PLASTIC(new String[]{"src/main/resources/SpriteImages/FinalSpriteImages/plastic_01.png", "src/main/resources/SpriteImages/FinalSpriteImages/plastic_02.png", "src/main/resources/SpriteImages/FinalSpriteImages/plastic_03.png"}),
    PAPER(new String[]{"src/main/resources/SpriteImages/FinalSpriteImages/paper_01.png", "src/main/resources/SpriteImages/FinalSpriteImages/paper_02.png", "src/main/resources/SpriteImages/FinalSpriteImages/paper_03.png", "src/main/resources/SpriteImages/FinalSpriteImages/paper_04.png"}),
    GLASS(new String[]{"src/main/resources/SpriteImages/FinalSpriteImages/glass_01.png", "src/main/resources/SpriteImages/FinalSpriteImages/glass_02.png", "src/main/resources/SpriteImages/FinalSpriteImages/glass_03.png", "src/main/resources/SpriteImages/FinalSpriteImages/glass_04.png"}),
    HAZARD(new String[]{"src/main/resources/SpriteImages/FinalSpriteImages/hazard_01.png", "src/main/resources/SpriteImages/FinalSpriteImages/hazard_02.png","src/main/resources/SpriteImages/FinalSpriteImages/hazard_03.png"}),
    TRASH(new String[]{"src/main/resources/SpriteImages/FinalSpriteImages/trash_01.png", "src/main/resources/SpriteImages/FinalSpriteImages/trash_02.png", "src/main/resources/SpriteImages/FinalSpriteImages/trash_03.png"});

    private String[] imagePaths;
    private static final Logger logger = Logger.getLogger(RecyclableType.class);

    private RecyclableType(String[] imagePaths) {
    	this.imagePaths = imagePaths;
    }

	public String[] getImagePaths() {
		return imagePaths;
	}

    public static void preLoadImages() {
        ResourceManager resourceManager = ResourceManager.getInstance();
        for(RecyclableType r : RecyclableType.values()){
            for(String s : r.getImagePaths()){
                logger.debug("Trying to preload image: " + s);
                resourceManager.getImage(s);

            }
        }
    }

}