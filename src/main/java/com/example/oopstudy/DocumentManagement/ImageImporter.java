package com.example.oopstudy.DocumentManagement;

import static com.example.oopstudy.DocumentManagement.Attributes.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

public class ImageImporter implements Importer{

  @Override
  public Document importFile(final File file) throws IOException {

    final Map<String, String> attributes = new HashMap<>();
    attributes.put(PATH, file.getPath());

    BufferedImage image = ImageIO.read(file);
    attributes.put( WIDTH, String.valueOf(image.getWidth()));
    attributes.put( HEIGHT, String.valueOf(image.getHeight()));
    attributes.put( TYPE,  "IMAGE");


    return new Document(attributes);

  }
}
