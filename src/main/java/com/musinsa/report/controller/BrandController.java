package com.musinsa.report.controller;

import com.musinsa.report.domain.Brand;
import com.musinsa.report.domain.BrandService;
import com.musinsa.report.dto.MinTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path ="/brand")
public class BrandController implements BaseController{
    @Autowired
    BrandService brandService;

    @GetMapping("/all/min")
    public List<MinTotal> getMinAll(){
        List<MinTotal> resData = new ArrayList<>();

        MinTotal inData = new MinTotal();
        List<Brand> data = brandService.getMinMaxAccessoriesBrand();
        Brand brand = data.get(0);

        inData.setCategory("악세사리");
        inData.setName(brand.getName());
        inData.setTotalValue(brand.getAccessories());
        resData.add(inData);

        //
        data = brandService.getMinMaxBAGBrand();
        brand = data.get(0);

        MinTotal bagData = new MinTotal();
        bagData.setCategory("가방");
        bagData.setName(brand.getName());
        bagData.setTotalValue(brand.getBag());
        resData.add(bagData);

        //
        data = brandService.getMinMaxCAPBrand();
        brand = data.get(0);

        MinTotal capData = new MinTotal();
        capData.setCategory("모자");
        capData.setName(brand.getName());
        capData.setTotalValue(brand.getCap());
        resData.add(capData);

        //
        data = brandService.getMinMaxOUTERBrand();
        brand = data.get(0);

        MinTotal outerData = new MinTotal();
        outerData.setCategory("아우터");
        outerData.setName(brand.getName());
        outerData.setTotalValue(brand.getOuter());
        resData.add(outerData);

        //
        data = brandService.getMinMaxPantsBrand();
        brand = data.get(0);

        MinTotal pantsData = new MinTotal();
        pantsData.setCategory("바지");
        pantsData.setName(brand.getName());
        pantsData.setTotalValue(brand.getPants());
        resData.add(pantsData);

        //
        data = brandService.getMinMaxShoesBrand();
        brand = data.get(0);

        MinTotal shoesData = new MinTotal();
        shoesData.setCategory("신발");
        shoesData.setName(brand.getName());
        shoesData.setTotalValue(brand.getShoes());
        resData.add(shoesData);

        //
        data = brandService.getMinMaxTopBrand();
        brand = data.get(0);

        MinTotal topData = new MinTotal();
        topData.setCategory("상의");
        topData.setName(brand.getName());
        topData.setTotalValue(brand.getTop());
        resData.add(topData);

        //
        data = brandService.getMinMaxSneakersBrand();
        brand = data.get(0);

        MinTotal kersData = new MinTotal();
        kersData.setCategory("스니커즈");
        kersData.setName(brand.getName());
        kersData.setTotalValue(brand.getSneakers());
        resData.add(kersData);

        return resData;
    }

    @GetMapping("/min/max/{category}")
    public List<Brand> getMinMaxCategory(@PathVariable("category") String category) {
        List<Brand> resData;

        switch (category.toLowerCase()){
            case "accessories":
                resData = brandService.getMinMaxAccessoriesBrand();
                break;

            case "bag":
                resData = brandService.getMinMaxBAGBrand();
                break;

            case "cap":
                resData = brandService.getMinMaxCAPBrand();
                break;

            case "outer":
                resData = brandService.getMinMaxOUTERBrand();
                break;

            case "pants":
                resData = brandService.getMinMaxPantsBrand();
                break;

            case "shoes":
                resData = brandService.getMinMaxShoesBrand();
                break;

            case "sneakers":
                resData = brandService.getMinMaxSneakersBrand();
                break;

            case "top":
                resData = brandService.getMinMaxTopBrand();
                break;

            default:
                resData = null;
                break;
        }

        return resData;
    }

    @GetMapping("/total/min")
    public Map getToalMinValue(){
        Map<String, Object> resData = new HashMap<>();

        try {
            List<MinTotal> minTotal = brandService.getMinBrand();
            resData.put(minTotal.get(0).getName(), minTotal.get(0).getTotalValue());
        }catch (Exception ex){
            resData = null;
            ex.printStackTrace();
        }

        return resData;
    }

    @PostMapping("/{brand_id}")
    public Map setData(@PathVariable("brand_id") String brandId, @RequestBody Map reqData){
        Map<String, Object> resData = new HashMap<>();

        try {
            Brand brand = mapper.convertValue(reqData, Brand.class);
            brand.setName(brandId);

            brandService.save(brand);

            resData.put("result", 1);
            resData.put("msg", "정상적으로 생성 되었습니다.");
            resData.put("data", brand);
        }catch (Exception ex){
            resData.put("result", -1);
            resData.put("msg", ex.getMessage());
        }
        return resData;
    }

    @PutMapping("/{brand_id}")
    public Map updateData(@PathVariable("brand_id") String brandId, @RequestBody Map reqData){
        Map<String, Object> resData = new HashMap<>();

        try {
            Brand brand = brandService.findById(brandId);
            Brand updateBrand = mapper.convertValue(reqData, Brand.class);

            if (updateBrand.getAccessories() != 0) {
                brand.setAccessories(updateBrand.getAccessories());
            }

            brandService.save(brand);

            resData.put("result", 1);
            resData.put("msg", "정상적으로 업데이트 되었습니다.");
            resData.put("data", brand);
        }catch (Exception ex){
            resData.put("result", -1);
            resData.put("msg", ex.getMessage());
        }
        return resData;
    }

    @DeleteMapping("/{brand_id}")
    public Map deleteData(@PathVariable("brand_id") String brandId, @RequestBody Map reqData){
        Map<String, Object> resData = new HashMap<>();
        try {
            brandService.deleteById(brandId);

            resData.put("result", 1);
            resData.put("msg", "정상적으로 삭제 되었습니다.");
        }catch (Exception ex){
            resData.put("result", -1);
            resData.put("msg", ex.getMessage());
        }

        return resData;
    }
}
