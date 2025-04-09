package com.geciara.orcamento.service;

import com.geciara.orcamento.dto.UnitMeasureRequestDTO;
import com.geciara.orcamento.dto.UnitMeasureResponseDTO;
import com.geciara.orcamento.dto.UnitMeasureUpdateRequestDTO;
import com.geciara.orcamento.exceptions.ItemNotFoundException;
import com.geciara.orcamento.mapper.UnitMeasureMapper;
import com.geciara.orcamento.model.entitys.UnitMeasureEntity;
import com.geciara.orcamento.repository.UnitMeasureRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UnitMeasureService {

    private final UnitMeasureRepository unitMeasureRepository;
    private final UnitMeasureMapper unitMeasureMapper;

    public UnitMeasureService(UnitMeasureRepository unitMeasureRepository, UnitMeasureMapper unitMeasureMapper) {
        this.unitMeasureRepository = unitMeasureRepository;
        this.unitMeasureMapper = unitMeasureMapper;
    }

    public UnitMeasureResponseDTO save(UnitMeasureRequestDTO dto) {
        UnitMeasureEntity unitMeasure = unitMeasureMapper.toUnitMeasureEntity(dto);
        unitMeasure = unitMeasureRepository.save(unitMeasure);
        return unitMeasureMapper.toResponseDTO(unitMeasure);
    }

    public List<UnitMeasureResponseDTO> listAll() {
        return unitMeasureRepository.findAll()
                .stream()
                .map(unitMeasureMapper::toResponseDTO)
                .toList();
    }

    public UnitMeasureResponseDTO findById(Long id) {
        UnitMeasureEntity unitMeasure = unitMeasureRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        return unitMeasureMapper.toResponseDTO(unitMeasure);
    }

    public UnitMeasureResponseDTO update(Long id, UnitMeasureUpdateRequestDTO dto) {
        UnitMeasureEntity unitMeasure = unitMeasureRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
        UnitMeasureEntity updatedUnitMeasure = unitMeasureMapper.updateEntityFromDTO(dto, unitMeasure);
        unitMeasureRepository.save(updatedUnitMeasure);
        return unitMeasureMapper.toResponseDTO(updatedUnitMeasure);
    }

    public void delete(Long id) {
        if (!unitMeasureRepository.existsById(id)) {
            throw new ItemNotFoundException();
        }
        unitMeasureRepository.deleteById(id);
    }


}
