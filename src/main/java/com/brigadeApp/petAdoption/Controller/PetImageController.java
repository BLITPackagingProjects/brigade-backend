package com.brigadeApp.petAdoption.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.brigadeApp.petAdoption.Entity.Pet;
import com.brigadeApp.petAdoption.Service.PetImageServImpl;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class PetImageController{

    private final PetImageServImpl petImageServImpl;
	
	@Autowired
	public PetImageController(PetImageServImpl petImageServImpl) {
		this.petImageServImpl = petImageServImpl;
	}

    @Value("${user.profile.image.path}")
    private String imageUploadPath;

    @PostMapping("/pet")
    public Pet registerPet(
            @RequestParam("petImage") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam("age") String age,
            @RequestParam("color") String color,
            @RequestParam("breed") String breed,
            @RequestParam("type") String type) throws IOException {
        
        //Uploaded the file but the name is not uploaded yet
        String imageName = petImageServImpl.uploadFile(image, imageUploadPath);

        //save new pet into db
        Pet petDB = new Pet();
        petDB.setImage(imageName); //Set the image name of the image that is uploaded by the client
        petDB.setAge(Integer.valueOf(age));
        petDB.setBreed(breed);
        petDB.setColor(color);
        petDB.setType(type);
        petDB.setName(name);
        return petImageServImpl.savePet(petDB); //Saving of user image name into database
    }

    @GetMapping("/pet/image/{petId}")
    public void getPetImage(
            @PathVariable("petId") long petId,
            HttpServletResponse response
    ) throws IOException {
        Pet petDB  = petImageServImpl.getPetById(petId);
        InputStream inputStream = petImageServImpl.getResource(imageUploadPath,petDB.getImage());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());
    }
    
}