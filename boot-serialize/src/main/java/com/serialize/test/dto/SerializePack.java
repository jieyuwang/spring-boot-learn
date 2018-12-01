package com.serialize.test.dto;

import com.serialize.test.pojo.DxPackRecv;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SerializePack implements Serializable {
    private String packageId;
    public  Map<String, List<DxPackRecv>> data = new HashMap<>();


}
