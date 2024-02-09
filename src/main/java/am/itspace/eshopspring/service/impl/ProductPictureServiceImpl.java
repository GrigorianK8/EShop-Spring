package am.itspace.eshopspring.service.impl;


import am.itspace.eshopspring.entity.Product;
import am.itspace.eshopspring.entity.ProductPicture;
import am.itspace.eshopspring.repository.ProductPictureRepository;
import am.itspace.eshopspring.service.ProductPictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductPictureServiceImpl implements ProductPictureService {

    private final ProductPictureRepository productPictureRepository;

    @Value("${picture.upload.directory}")
    private String uploadDirectory;

    @Override
    public ProductPicture save(ProductPicture productPicture) {
        return productPictureRepository.save(productPicture);
    }

    @Override
    public List<ProductPicture> findAllByProduct(Product product) {
        return productPictureRepository.findAllByProduct(product);
    }

    @Override
    public void saveAll(Product product, List<MultipartFile> multipartFiles) {
        if (multipartFiles != null && !multipartFiles.isEmpty()) {
            for (MultipartFile multipartFile : multipartFiles) {
                String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
                File file = new File(uploadDirectory, picName);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                save(ProductPicture.builder()
                        .product(product)
                        .picName(picName)
                        .build());
            }
        }
    }
}
