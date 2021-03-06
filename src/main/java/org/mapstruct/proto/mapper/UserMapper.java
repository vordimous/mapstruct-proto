/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.mapstruct.proto.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.mapstruct.proto.UserProtos;
import org.mapstruct.proto.protobuf.Permission;
import org.mapstruct.proto.protobuf.User;

/**
 * @author Thomas Kratz
 */
@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	@Mappings({
		@Mapping(source = "permissions", target = "permissionsList"),
		@Mapping(target = "allFields", ignore = true),
		@Mapping(target = "clearField", ignore = true),
		@Mapping(target = "clearOneof", ignore = true),
		@Mapping(target = "mergeFrom", ignore = true),
		@Mapping(target = "idBytes", ignore = true),
		@Mapping(target = "emailBytes", ignore = true),
		@Mapping(target = "permissionsValueList", ignore = true),
		@Mapping(target = "unknownFields", ignore = true),
		@Mapping(target = "mergeUnknownFields", ignore = true),

		// Maps
		@Mapping(target = "removeMetadata", ignore = true),
		@Mapping(target = "putAllMetadata", ignore = true),
		@Mapping(target = "metadataMap", ignore = true),
		@Mapping(target = "mutableMetadata", ignore = true),

	})
    UserProtos.UserDTO map(User user);

    @Mapping(source = "permissionsList", target = "permissions")
    User map(UserProtos.UserDTO userDTO);

    @ValueMapping(source = "UNRECOGNIZED", target = MappingConstants.NULL)
    Permission map(UserProtos.PermissionDTO permissionDTO);

    UserProtos.PermissionDTO map(Permission perm);

}
