package org.andengine.extension.debugdraw;

import org.andengine.extension.debugdraw.primitives.PolyLine;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Joint;

/**
 * Base implementation of joint and it's graphical representation bound together
 * @author nazgee
 */
class RenderOfJointPolyline extends RenderOfJoint {
	private float[] mXPoints;
	private float[] mYPoints;
	private int mVSize;

	public RenderOfJointPolyline(Joint joint, VertexBufferObjectManager pVBO) {
		super(joint);

		mVSize = 2;
		mXPoints = new float[mVSize];
		mYPoints = new float[mVSize];

		for (int i = 0; i < mVSize; i++) {
			mXPoints[i] = 0;
			mYPoints[i] = 0;
		}

		mEntity = new PolyLine(0, 0, mXPoints, mYPoints, pVBO);
	}

	@Override
	public PolyLine getEntity() {
		return (PolyLine) super.getEntity();
	}

	public void update() {
		Vector2 aA = getJoint().getAnchorA();
		Vector2 aB = getJoint().getAnchorB();

//		Body bA = getJoint().getBodyA();
//		Body bB = getJoint().getBodyB();
//
//		mXPoints[0] = bA.getWorldPoint(aA).x * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;
//		mYPoints[0] = bA.getWorldPoint(aA).y * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;
//
//		mXPoints[1] = bB.getWorldPoint(aB).x * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;
//		mYPoints[1] = bB.getWorldPoint(aB).y * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;

		mXPoints[0] = aA.x * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;
		mYPoints[0] = aA.y * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;

		mXPoints[1] = aB.x * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;
		mYPoints[1] = aB.y * PhysicsConnector.PIXEL_TO_METER_RATIO_DEFAULT;

		mXPoints[0] = 100;
		mYPoints[0] = 100;

		getEntity().updateVertices(mXPoints, mYPoints);
	}
}