package com.pinyougou.pojovo;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

public class SpecificationWithSpecificationOptions implements Serializable {

    private TbSpecification specification;

    private List<TbSpecificationOption> specificationOptions;

    public SpecificationWithSpecificationOptions(TbSpecification specification, List<TbSpecificationOption> specificationOptions) {
        this.specification = specification;
        this.specificationOptions = specificationOptions;
    }

    public SpecificationWithSpecificationOptions() {
    }

    public TbSpecification getSpecification() {
        return specification;
    }

    public void setSpecification(TbSpecification specification) {
        this.specification = specification;
    }

    public List<TbSpecificationOption> getSpecificationOptions() {
        return specificationOptions;
    }

    public void setSpecificationOptions(List<TbSpecificationOption> specificationOptions) {
        this.specificationOptions = specificationOptions;
    }
}
