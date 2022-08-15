package com.musinsa.report.domain;

import com.musinsa.report.dto.MinTotal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BrandService {
    @Autowired
    BrandDao brandDao;

    @Autowired
    BrandJdbcDao brandJdbcDao;

    @PostConstruct
    public void setData() throws Exception{
        ClassPathResource classPathResource = new ClassPathResource("static");
        String ststicFilePath =  classPathResource.getURL().getPath();

        List<String> csvData = readCSV(ststicFilePath + "/data.csv");

        List<Brand> brandList= new ArrayList<>();

        for(String s : csvData){
            String[] arr_s = s.split(",");
            if(arr_s[0].equals("accountId") == false) {
                Brand account = new Brand();
                account.setName(arr_s[0]);
                account.setTop(Integer.parseInt(arr_s[1]));
                account.setOuter(Integer.parseInt(arr_s[2]));
                account.setPants(Integer.parseInt(arr_s[3]));
                account.setSneakers(Integer.parseInt(arr_s[4]));
                account.setBag(Integer.parseInt(arr_s[5]));
                account.setCap(Integer.parseInt(arr_s[6]));
                account.setShoes(Integer.parseInt(arr_s[7]));
                account.setAccessories(Integer.parseInt(arr_s[8]));

                brandList.add(account);
            }
        }

        brandDao.saveAll(brandList);
    }


    @Transactional
    public Brand save(Brand brand) {
        return brandDao.save(brand);
    }

    @Transactional
    public List<Brand> saveAll(List<Brand> brands) { return brandDao.saveAll(brands); }

    public Brand findById(String id) { return brandDao.findById(id).get(); }
    public List<Brand> findAll() { return brandDao.findAll(); }

    @Transactional
    public void deleteById(String id) { brandDao.deleteById(id); }

    @Transactional
    public void deleteAll() { brandDao.deleteAll(); }

    public List<MinTotal> getMinBrand() {return brandJdbcDao.getTotalMinBrand(); }


    private List<String> readCSV(String fileName) {
        List<String> data = new ArrayList<>();
        File csv = new File(fileName);
        BufferedReader br = null;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(csv));
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch(IOException e) {
                e.printStackTrace();
            }

            return data;
        }
    }


    public List<Brand> getMinMaxBAGBrand(){ return brandJdbcDao.getMinMaxBAGBrand();}
    public List<Brand> getMinMaxCAPBrand(){ return brandJdbcDao.getMinMaxCAPBrand();}
    public List<Brand> getMinMaxOUTERBrand(){ return brandJdbcDao.getMinMaxOUTERBrand();}
    public List<Brand> getMinMaxAccessoriesBrand(){ return brandJdbcDao.getMinMaxAccessoriesBrand();}
    public List<Brand> getMinMaxPantsBrand(){ return brandJdbcDao.getMinMaxPantsBrand();}
    public List<Brand> getMinMaxShoesBrand(){ return brandJdbcDao.getMinMaxShoesBrand();}
    public List<Brand> getMinMaxSneakersBrand(){ return brandJdbcDao.getMinMaxSneakersBrand();}
    public List<Brand> getMinMaxTopBrand(){ return brandJdbcDao.getMinMaxTopBrand();}
}
