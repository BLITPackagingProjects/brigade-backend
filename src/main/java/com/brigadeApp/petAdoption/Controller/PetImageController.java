package com.brigadeApp.petAdoption.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.brigadeApp.petAdoption.Entity.ImageResponse;
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
	public Pet addPet(@RequestBody Pet pet) {
		return petImageServImpl.savePet(pet);
	}

    @PostMapping("/pet/image/{petId}")
    public ResponseEntity<ImageResponse> uploadImage(
            @RequestParam("petImage") MultipartFile image,
            @PathVariable("petId") long petId ) throws IOException {

        String imageName = petImageServImpl.uploadFile(image, imageUploadPath);//Uploaded the file but the name is not uploaded yet
        Pet petDB = petImageServImpl.getPetById(petId);

        petDB.setImage(imageName); //Set the image name of the image that is uploaded by the client

        petImageServImpl.savePet(petDB); //Saving of user image name into database

        ImageResponse imageResponse = ImageResponse.builder()
                .imageName(imageName)
                .message("Image uploaded")
                .status(HttpStatus.OK)
                .success(true)
                .build();
        return new ResponseEntity<>(imageResponse, HttpStatus.OK);
    }

    @GetMapping("/pet/image/{petId}")
    public void getUserImage(
            @PathVariable("petId") long petId,
            HttpServletResponse response
    ) throws IOException {

        Pet petDB  = petImageServImpl.getPetById(petId);
        InputStream inputStream = petImageServImpl.getResource(imageUploadPath,petDB.getImage());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        StreamUtils.copy(inputStream, response.getOutputStream());

    }
}