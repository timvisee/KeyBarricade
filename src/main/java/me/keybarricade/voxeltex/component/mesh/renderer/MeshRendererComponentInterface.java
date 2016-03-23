package me.keybarricade.voxeltex.component.mesh.renderer;

import me.keybarricade.voxeltex.component.drawable.DrawableComponentInterface;
import me.keybarricade.voxeltex.component.mesh.filter.MeshFilterComponentInterface;
import me.keybarricade.voxeltex.material.Material;

import java.util.List;

public interface MeshRendererComponentInterface extends DrawableComponentInterface {

    /**
     * Get the mesh filter component that is attached and used for rendering.
     *
     * @return Mesh filter component.
     */
    MeshFilterComponentInterface getMeshFilterComponent();

    /**
     * Check whether a mesh filter component is attached and used for rendering.
     *
     * @return True if a mesh filter is attached, false if not.
     */
    boolean hasMeshFilterComponent();

    /**
     * Set the mesh filter component that is attached and used for rendering.
     *
     * @param meshFilter Mesh filter component.
     */
    void setMeshFilterComponent(MeshFilterComponentInterface meshFilter);

    /**
     * Add a material to the mesh renderer.
     *
     * @param material Material.
     */
    void addMaterial(Material material);

    /**
     * Get all materials used with this mesh renderer.
     *
     * @return List of materials.
     */
    List<Material> getMaterials();

    /**
     * Get the main material. If the mesh renderer has multiple materials, the first will be returned.
     *
     * @return Material.
     */
    Material getMaterial();

    /**
     * Get the material at the given index.
     *
     * @param i Material index.
     *
     * @return Material.
     */
    Material getMaterial(int i);

    /**
     * Get the number of materials used with this mesh renderer.
     *
     * @return Material count.
     */
    int getMaterialCount();

    /**
     * Check whether this mesh renderer has any materials available for rendering.
     *
     * @return True if this mesh renderer has any materials, false if not.
     */
    boolean hasMaterial();

    /**
     * Set the list of materials used with this mesh renderer.
     *
     * @param materials List of materials.
     */
    void setMaterials(List<Material> materials);

    /**
     * Set the material used for rendering. This will clear all materials that were already attached.
     *
     * @param material Material.
     */
    void setMaterial(Material material);

    /**
     * Remove the given material from the mesh renderer.
     *
     * @param material Material to remove.
     *
     * @return True if any material was removed, false if not.
     */
    boolean removeMaterial(Material material);

    /**
     * Remove the material at the given index.
     *
     * @param i Material index.
     *
     * @return The material that was removed.
     */
    Material removeMaterial(int i);
}
